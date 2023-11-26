////////////////////////////////////////////////
////        Decision tree classifier        ////
////////////////////////////////////////////////

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder.getOrCreate()

// Importa los datos almacenados en formato LIBSVM y colócalos en un DataFrame.
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

// Etiqueta las etiquetas, añadiendo metadatos a la columna de etiquetas.
// Ajusta en todo el conjunto de datos para incluir todas las etiquetas en el índice.
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)

// Identifica automáticamente las características categóricas y las indexa.
// Las características con más de 4 valores distintos se tratan como continuas.
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)

// Divide los datos en conjuntos de entrenamiento y prueba (30% reservado para pruebas).
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

// Entrena un modelo de Árbol de Decisión.
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

// Convierte las etiquetas indexadas a etiquetas originales.
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labelsArray(0))

// Encadena indexadores y árbol en un Pipeline.
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))

// Entrenar el modelo. Esto también ejecuta los indexadores.
val model = pipeline.fit(trainingData)

// Hacer predicciones.
val predictions = model.transform(testData)

// Selecciona filas de ejemplo para mostrar.
predictions.select("predictedLabel", "label", "features").show(5)

// Seleccionar (predicción, etiqueta verdadera) y calcular el error de prueba.
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Prueba de Error = ${(1.0 - accuracy)}")

val treeModel = model.stages(5).asInstanceOf[DecisionTreeClassificationModel]
println(s"Modelo de arbol de clasificacion aprendido:\n ${treeModel.toDebugString}")

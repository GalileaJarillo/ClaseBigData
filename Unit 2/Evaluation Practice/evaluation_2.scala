import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}

// Crear una sesión de Spark
val spark = SparkSession.builder().getOrCreate()

// Cargar datos en un DataFrame
val data = spark.read.option("header", "true").format("libsvm").csv("iris.csv")

// 2. Nombres de las columnas
data.columns.foreach(println)

// 3. Esquema del DataFrame
data.printSchema()

// 4. Imprimir las primeras 5 filas
data.show(5)

// 5. Método describe()
data.describe().show()


// 6. Transformación para datos categóricos (etiquetas a clasificar)
val labelIndexer = new StringIndexer().setInputCol("sepal_length","sepal_width","petal_length","petal_width").setOutputCol("label").fit(data)

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


// // 7. Construcción del modelo de clasificación (MLP)
// val layers = Array[Int](4, 5, 4, 3)

// // create the trainer and set its parameters
// val trainer = new MultilayerPerceptronClassifier()
//   .setLayers(layers)
//   .setBlockSize(128)
//   .setSeed(1234L)
//   .setMaxIter(100)

// // train the model
// val model = trainer.fit(train)

// // compute accuracy on the test set
// // 8. Resultados del modelo y observaciones
// val result = model.transform(indexedData)
// val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
// val accuracy = evaluator.evaluate(predictions)
// println(s"Prueba de Error = ${(1.0 - accuracy)}")

// val treeModel = model.stages(5).asInstanceOf[DecisionTreeClassificationModel]
// println(s"Modelo de arbol de clasificacion aprendido:\n ${treeModel.toDebugString}")


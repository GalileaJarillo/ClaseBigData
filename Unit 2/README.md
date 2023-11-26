# Unit II 
## Practice 1 - Linear Regression Exercise
### Importe una SparkSession con la librería Linear Regression
```
import org.apache.spark.ml.regression.LinearRegression
```
### Opcional utilice el código para configurar errores
```
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```
### Inicie una simple Sesion Spark
``` 
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
``` 
### Utilice Spark para el archivo csv Clean-Ecommerce
``` 
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load ;"Clean-Ecommerce.csv"
``` 
### Imprima el schema en el DataFrame
```
data.printSchema()
```
```sh
root
 |-- Email: string (nullable = true)
 |-- Avatar: string (nullable = true)
 |-- Avg Session Length: double (nullable = true)
 |-- Time on App: double (nullable = true)
 |-- Time on Website: double (nullable = true)
 |-- Length of Membership: double (nullable = true)
 |-- Yearly Amount Spent: double (nullable = true)
``` 
### Imprima un renglon de ejemplo del DataFrane.
``` 
data.head(1)
val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)) {
    println(s"${colnames(ind)} => ${firstrow(ind)}")
}
```
```sh
Avatar => Violet
Avg Session Length => 34.49726772511229
Time on App => 12.65565114916675
Time on Website => 39.57766801952616
Length of Membership => 4.0826206329529615
Yearly Amount Spent => 587.9510539684005
```
### Configure el dataframe para machine learning
### Transforme el data frame para que tome la forma de ("label","features")
### Importe vectorassembler y vectors
```
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
data.columns
``` 
### Renombre la columna Yearly Amount Spent como "label"
### Tambien de los datos tome solo la columa numerica 
### Deje todo esto como un nuevo DataFrame que se llame df
```
val df = (data.select(data("Yearly Amount Spent").as("label"), $"Avg Session Length", $"Time on App", $"Time on Website", $"Length of Membership"))
```
### Que el objeto assembler convierta los valores de entrada a un vector
### Utilice el objeto VectorAssembler para convertir la columnas de entradas del df a una sola columna de salida de un arreglo llamado  "features"
```
val assembler = (new VectorAssembler().setInputCols(Array("Avg Session Length", "Time on App", "Time on Website", "Length of Membership")).setOutputCol("features"))
```
### Configure las columnas de entrada de donde se supone que leemos los valores.
### Llamar a esto nuevo assambler.
### Utilice el assembler para transform nuestro DataFrame a dos columnas: label and features
```
val newAssembler = assembler.transform(df).select($"label", $"features")
newAssembler.show()
```
### Crear un objeto para modelo de regresion linea.
```
import org.apache.spark.ml.classification.LinearRegression
```
### Ajuste el modelo para los datos y llame a este modelo lrModelo
```
val lr = new LinearRegression()
val lrModelo = lr.fit(newAssembler)
```
### Imprima the  coefficients y intercept para la regresion lineal
### Resuma el modelo sobre el conjunto de entrenamiento imprima la salida de algunas metricas!
### Utilice método .summary de nuestro  modelo para crear un objeto llamado trainingSummary
```
val trainingSummary = lrModelo.summary
```
### Muestre los valores de residuals, el RMSE, el MSE, y tambien el R^2 .
```
trainingSummary.residuals.show()
trainingSummary.predictions.show()
trainingSummary.r2
trainingSummary.rootMeanSquaredError
```
```sh
+-------------------+
|          residuals|
+-------------------+
| -6.788234090018818|
| 11.841128565326073|
| -17.65262700858966|
| 11.454889631178617|
| 7.7833824373080915|
|-1.8347332184773677|
|  4.620232401352382|
| -8.526545950978175|
| 11.012210896516763|
|-13.828032682158891|
| -16.04456458615175|
|  8.786634365463442|
| 10.425717191807507|
| 12.161293785003522|
|  9.989313714461446|
| 10.626662732649379|
|  20.15641408428496|
|-3.7708446586326545|
| -4.129505481591934|
|  9.206694655890487|
+-------------------+
+------------------+--------------------+------------------+
|             label|            features|        prediction|
+------------------+--------------------+------------------+
| 587.9510539684005|[34.4972677251122...| 594.7392880584193|
| 392.2049334443264|[31.9262720263601...| 380.3638048790003|
|487.54750486747207|[33.0009147556426...|505.20013187606173|
| 581.8523440352177|[34.3055566297555...| 570.3974544040391|
| 599.4060920457634|[33.3306725236463...| 591.6227096084554|
|  637.102447915074|[33.8710378793419...| 638.9371811335513|
| 521.5721747578274|[32.0215955013870...|  516.951942356475|
| 549.9041461052942|[32.7391429383803...| 558.4306920562724|
| 570.2004089636196|[33.9877728956856...| 559.1881980671028|
| 427.1993848953282|[31.9365486184489...| 441.0274175774871|
| 492.6060127179966|[33.9925727749537...| 508.6505773041483|
| 522.3374046069357|[33.8793608248049...| 513.5507702414723|
| 408.6403510726275|[29.5324289670579...|   398.21463388082|
| 573.4158673313865|[33.1903340437226...|  561.254573546383|
| 470.4527333009554|[32.3879758531538...|460.46341958649396|
| 461.7807421962299|[30.7377203726281...| 451.1540794635805|
|457.84769594494855|[32.1253868972878...| 437.6912818606636|
|407.70454754954415|[32.3388993230671...| 411.4753922081768|
| 452.3156754800354|[32.1878120459321...|456.44518096162733|
|  605.061038804892|[32.6178560628234...| 595.8543441490015|
+------------------+--------------------+------------------+
res22: Double = 0.9843155370226727
res23: Double = 9.923256785022229
```


## Practice 2 - Proyecto de Regresion Logistica
### Importe una  SparkSession con la libreria Logistic Regression
```
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
```
### Optional: Utilizar el codigo de  Error reporting
```
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```
### Cree un sesion Spark 
```
val spark = SparkSession.builder().getOrCreate()
```
### Utilice Spark para leer el archivo csv Advertising.
```
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv")
```
```sh
data: org.apache.spark.sql.DataFrame = [Daily Time Spent on Site: double, Age: int ... 8 more fields]
```
### Imprima el Schema del DataFrame
```
data.printSchema()
```
```sh
root
 |-- Daily Time Spent on Site: double (nullable = true)
 |-- Age: integer (nullable = true)
 |-- Area Income: double (nullable = true)
 |-- Daily Internet Usage: double (nullable = true)
 |-- Ad Topic Line: string (nullable = true)
 |-- City: string (nullable = true)
 |-- Male: integer (nullable = true)
 |-- Country: string (nullable = true)
 |-- Timestamp: timestamp (nullable = true)
 |-- Clicked on Ad: integer (nullable = true)
```
### Imprima un renglon de ejemplo
```
data.head(1)
val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for (ind <- Range(1, colnames.length)) {
    println(s"${colnames(ind)} => ${firstrow(ind)}")
}
```
```sh
Example data row
Age => 35
Area Income => 61833.9
Daily Internet Usage => 256.09
Ad Topic Line => Cloned 5thgeneration orchestration
City => Wrightburgh
Male => 0
Country => Tunisia
Timestamp => 2016-03-27 00:53:11.0
Clicked on Ad => 0
```
### Renombre la columna "Clicked on Ad" a "label"
### Tome la siguientes columnas como features "Daily Time Spent on Site","Age","Area Income","Daily Internet Usage","Timestamp","Male"
### Cree una nueva clolumna llamada "Hour" del Timestamp conteniendo la  "Hour of the click"
```
val timedata = data.withColumn("Hour",hour(data("Timestamp")))
```
```
val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily Internet Usage", $"Hour", $"Male")
```
### Importe VectorAssembler y Vectors
```
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
```
### Cree un nuevo objecto VectorAssembler llamado assembler para los feature
```
val assembler = (new VectorAssembler().setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male")).setOutputCol("features"))
```
### Utilice randomSplit para crear datos de train y test divididos en 70/30
```
val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)
```
### Importe  Pipeline
```
import org.apache.spark.ml.Pipeline
```
### Cree un nuevo objeto de  LogisticRegression llamado lr
```
val lr = new LogisticRegression()
```
### Cree un nuevo  pipeline con los elementos: assembler, lr
```
val pipeline = new Pipeline().setStages(Array(assembler, lr))
```
### Ajuste (fit) el pipeline para el conjunto de training.
```
val model = pipeline.fit(training)
```
### Tome los Resultados en el conjuto Test con transform
```
val results = model.transform(test)
```
### Para Metrics y Evaluation importe MulticlassMetrics
```
import org.apache.spark.mllib.evaluation.MulticlassMetrics
```
### Convierta los resutalos de prueba (test) en RDD utilizando .as y .rdd
```
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
```
### Inicialice un objeto MulticlassMetrics 
```
val metrics = new MulticlassMetrics(predictionAndLabels)
```
### Imprima la  Confusion matrix
```
println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy
```
```sh
Confusion matrix:
136.0  1.0    
4.0    146.0
res75: Double = 0.9825783972125436
```


## Practice 3 - Decision tree classifier
### Importar librerias
```
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.sql.SparkSession
```
### Crear sesion de spark
```
```
### Importa los datos almacenados en formato LIBSVM y colócalos en un DataFrame.
```
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
```
### Etiqueta las etiquetas, añadiendo metadatos a la columna de etiquetas.
### Ajusta en todo el conjunto de datos para incluir todas las etiquetas en el índice.
```
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
```
### Identifica automáticamente las características categóricas y las indexa.
### Las características con más de 4 valores distintos se tratan como continuas.
```
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
```
### Divide los datos en conjuntos de entrenamiento y prueba (30% reservado para pruebas).
```
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
```
### Entrena un modelo de Árbol de Decisión.
```
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")
```
### Convierte las etiquetas indexadas a etiquetas originales.
```
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labelsArray(0))
```
### Encadena indexadores y árbol en un Pipeline.
```
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
```
### Entrenar el modelo. Esto también ejecuta los indexadores.
```
val model = pipeline.fit(trainingData)
```
### Hacer predicciones.
```
val predictions = model.transform(testData)
```
### Selecciona filas de ejemplo para mostrar.
```
predictions.select("predictedLabel", "label", "features").show(5)
```
```sh
+--------------+-----+--------------------+
|predictedLabel|label|            features|
+--------------+-----+--------------------+
|           0.0|  0.0|(692,[100,101,102...|
|           0.0|  0.0|(692,[121,122,123...|
|           0.0|  0.0|(692,[123,124,125...|
|           0.0|  0.0|(692,[124,125,126...|
|           0.0|  0.0|(692,[125,126,127...|
+--------------+-----+--------------------+
```
### Seleccionar (predicción, etiqueta verdadera) y calcular el error de prueba.
```
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
```
```sh
println(s"Prueba de Error = ${(1.0 - accuracy)}")
```
### Imprimir modelo de clasificacion
```
val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
```
```sh
println(s"Modelo de árbol de clasificación aprendido:\n ${treeModel.toDebugString}")
```


## Practice 4 - MultilayerPerceptronClassifier
### Importe una  SparkSession con la libreria Multilayer Perceptron Classifier
```
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```
### Cargue la información almacenada en LIBSVM formato como un DataFrame.
```
val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")
```
### Divida la información entre entrenar y test
```
val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)
```
### Específique las capas de la red neuronal conecte las capas 4 (features), 2 intermedias de medida 5 y 4, salida de tamaño 3 (classes)
```
val layers = Array[Int](4, 5, 4, 3)
```
### Crea el trainer and set its parameters
```
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)
```
### Entrena el modelo
```
val model = trainer.fit(train)
```
### Completa accuracy en el test set
```
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
val evaluator: org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator = MulticlassClassificationEvaluator: uid=mcEval_13e2d9950949, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15
```
```sh
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```
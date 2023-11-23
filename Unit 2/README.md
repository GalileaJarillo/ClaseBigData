# Unit II 
## Practice 1
### [title]
```
[code]
```
```sh
[results]
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

## Practice 3
### [title]
```
[code]
```
```sh
[results]
```

## Practice 4
### MultilayerPerceptronClassifier
### Importe una  SparkSession con la libreria Multilayer Perceptron Classifier
```
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

[code]
```
### // Cargue la información almacenada en LIBSVM formato como un DataFrame.
```
val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")

### // Divida la información entre entrenar y test
```
val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

### // Específique las capas de la red neuronal // conecte las capas 4 (features), 2 intermedias de medida 5 y 4 // and output of size 3 (classes)
```
val layers = Array[Int](4, 5, 4, 3)

### Crea el trainer and set its parameters
```
val trainer = new MultilayerPerceptronClassifier()
  .setLayers(layers)
  .setBlockSize(128)
  .setSeed(1234L)
  .setMaxIter(100)
### Entrena el modelo
```
val model = trainer.fit(train)
### Completa accuracy en el test set
```
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
```
val evaluator = new MulticlassClassificationEvaluator()
  .setMetricName("accuracy")
```sh
val evaluator: org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator = MulticlassClassificationEvaluator: uid=mcEval_13e2d9950949, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15
```
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
[results]
```sh


# Examn
### [title]
```
[code]
```
```sh
[results]
```
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
### [title]
```
[code]
```
```sh
[results]
```

# Examn
### [title]
```
[code]
```
```sh
[results]
```
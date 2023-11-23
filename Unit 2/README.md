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
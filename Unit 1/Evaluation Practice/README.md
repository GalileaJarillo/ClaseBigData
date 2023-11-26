# Evaluation Practice 1
### 1. Comienza una simple sesión Spark.
```
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
```

### 2. Cargue el archivo Netflix Stock CSV en dataframe llamado df, haga que Spark infiera los tipos de datos.
```
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")
```

### 3. ¿Cuáles son los nombres de las columnas?
Date, Open, High, Low, Close, Volume, Adj Close

#### 4. ¿Cómo es el esquema?
```
scala> df.printSchema()
```
```sh
root
 |-- Date: date (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
 |-- Adj Close: double (nullable = true)
```

### 5. Imprime las primeras 5 renglones.
```
scala> df.show(5)
scala> df.head(5)
```

### 6. Usa el método describe () para aprender sobre el DataFrame.
```
scala> df.describe().show()
```
```sh
WARN SparkStringUtils: Truncated the string representation of a plan since it was too large. This behavior can be adjusted by setting 'spark.sql.debug.maxToStringFields'.+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|summary|              Open|              High|               Low|             Close|              Volume|         Adj Close|
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|  count|              1259|              1259|              1259|              1259|                1259|              1259|
|   mean|230.39351086656092|233.97320872915006|226.80127876251044|  230.522453845909|2.5634836060365368E7|55.610540036536875|
| stddev|164.37456353264244| 165.9705082667129| 162.6506358235739|164.40918905512854| 2.306312683388607E7|35.186669331525486|
|    min|         53.990001|         55.480001|             52.81|              53.8|             3531300|          7.685714|
|    max|        708.900017|        716.159996|        697.569984|        707.610001|           315541800|        130.929993|
+-------+------------------+-------
```

### 7. Crea un nuevo Dataframe a partir del df creado anteriormente llamdo “HVRatio” para crear una columna nueva llamada “HV Ratio” que es la relación que existe entre el precio de la columna “High” frente a la columna “Volumen” de acciones negociadas por un día. Hint - es una operación
```
val HVRatio = df.withColumn("HV Ratio", (df("High") / df("Volume")))
scala> HVRatio.show(5)
```
```sh
+----------+----------+------------------+----------+-----------------+---------+------------------+--------------------+
|      Date|      Open|              High|       Low|            Close|   Volume|         Adj Close|            HV Ratio|
+----------+----------+------------------+----------+-----------------+---------+------------------+--------------------+
|2011-10-24|119.100002|120.28000300000001|115.100004|       118.839996|120460200|         16.977142|9.985040951285156E-7|
|2011-10-25| 74.899999|         79.390001| 74.249997|        77.370002|315541800|11.052857000000001|2.515989989281927E-7|
|2011-10-26|     78.73|         81.420001| 75.399997|        79.400002|148733900|         11.342857|5.474206014903126E-7|
|2011-10-27| 82.179998| 82.71999699999999| 79.249998|80.86000200000001| 71190000|11.551428999999999|1.161960907430818...|
|2011-10-28| 80.280002|         84.660002| 79.599999|84.14000300000001| 57769600|             12.02|1.465476686700271...|
+----------+----------+------------------+----------+-----------------+---------+------------------+--------------------+
```

### 8. ¿Qué día tuvo el pico más alto en la columna “Open”?
```
scala> df.orderBy(desc("Open")).first()
scala> df.orderBy(desc("Open")).show(1)
```
```sh
+----------+----------+----------+----------+----------+--------+----------+
|      Date|      Open|      High|       Low|     Close|  Volume| Adj Close|
+----------+----------+----------+----------+----------+--------+----------+
|2015-07-14|708.900017|711.449982|697.569984|702.600006|19736500|100.371429|
```

### 9. ¿Cuál es el significado de la columna Cerrar “Close” en el contexto de información financiera, explíquelo no hay que codificar nada?
Consideramos que se refiere al precio de cierre de cada una de las fechas determinadas respecto a los datos proporcionados en la tabla. El precio de cierre es uno de los valores más importantes y ampliamente seguidos en el mundo de las finanzas y se utiliza en una variedad de análisis y cálculos.

### 10. ¿Cuál es el máximo y mínimo de la columna “Volumen”?
```
scala> df.agg(max("Volume")).show()
```
```sh
+-----------+
|max(Volume)|
+-----------+
|  315541800|
+-----------+
```
```
scala> df.agg(min("Volume")).show()
```
```sh
+-----------+
|min(Volume)|
+-----------+
|    3531300|
+-----------+
```

### 11. Con Sintaxis Scala/Spark $ conteste lo siguiente:
#### a) ¿Cuántos días fue la columna “Close” inferior a $ 600?
```
scala> df.filter("Close < 600").count()
```
```sh
res96: Long = 1218
```
#### b) ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
```
val totalRows = df.count()
val greaterRows = df.filter("High > 500").count()
scala> (greaterRows.toDouble / totalRows) * 100 
```
```sh
val res1: Double = 4.924543288324067
```

#### c) ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?
```
scala> df.select(corr("High", "Volume")).show()
```
```sh
+--------------------+
|  corr(High, Volume)|
+--------------------+
|-0.20960233287942157|
+--------------------+
```
#### d) ¿Cuál es el máximo de la columna “High” por año?
```
scala> df.groupBy(year(col("Date")).alias("Year")).agg(max("High").alias("MaxHigh")).show()
```
```sh
+----+------------------+
|Year|           MaxHigh|
+----+------------------+
|2015|        716.159996|
|2013|        389.159988|
|2014|        489.290024|
|2012|        133.429996|
|2016|129.28999299999998|
|2011|120.28000300000001|
+----+------------------+
```

#### e) ¿Cuál es el promedio de la columna “Close” para cada mes del calendario?
```
scala> df.groupBy(year(col("Date")).alias("Year"), month(col("Date")).alias("Month")).agg(avg("Close").alias("AvgClose")).orderBy(desc("Year"
)).show()
```
```sh
+----+-----+------------------+
|Year|Month|          AvgClose|
+----+-----+------------------+
|2016|    7| 93.16349985000002|
|2016|    5| 93.17476147619047|
|2016|    2| 89.96950000000001|
|2016|    9| 97.44857128571428|
|2016|   10|    109.0562500625|
|2016|    6| 94.29863663636364|
|2016|    1|105.44789489473683|
|2016|    4|100.81190457142858|
|2016|    8| 95.62260904347829|
|2016|    3| 99.31590927272727|
|2015|   12|121.29636322727274|
|2015|    7|339.94727122727267|
|2015|   11|116.06949959999997|
|2015|    8|117.50285638095235|
|2015|    4| 505.8238118095239|
|2015|    2| 462.9221038421052|
|2015|    9|100.56571519047618|
|2015|   10|105.58772759090908|
|2015|    3|437.66090550000007|
|2015|    6| 652.4349957727273|
+----+-----+------------------+
only showing top 20 rows
```

##### Ordenado por año
```
scala> df.groupBy(year(col("Date")).alias("Year"), month(col("Date")).alias("Month")).agg(avg("Close").alias("AvgClose")).orderBy(desc("Year"
)).show()
```
```sh
+----+-----+------------------+
|Year|Month|          AvgClose|
+----+-----+------------------+
|2016|    7| 93.16349985000002|
|2016|    5| 93.17476147619047|
|2016|    2| 89.96950000000001|
|2016|    9| 97.44857128571428|
|2016|   10|    109.0562500625|
|2016|    6| 94.29863663636364|
|2016|    1|105.44789489473683|
|2016|    4|100.81190457142858|
|2016|    8| 95.62260904347829|
|2016|    3| 99.31590927272727|
|2015|   12|121.29636322727274|
|2015|    7|339.94727122727267|
|2015|   11|116.06949959999997|
|2015|    8|117.50285638095235|
|2015|    4| 505.8238118095239|
|2015|    2| 462.9221038421052|
|2015|    9|100.56571519047618|
|2015|   10|105.58772759090908|
|2015|    3|437.66090550000007|
|2015|    6| 652.4349957727273|
+----+-----+------------------+
only showing top 20 rows
```

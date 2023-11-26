# Evaluation Practice 2

## Instrucciones
## Desarrollar las siguientes instrucciones en Spark con el lenguaje de programación Scala, utilizando solo la documentación de la librería de Machine Learning Mllib de Spark y Google.

### 1. Cargar en un dataframe de la fuente de datos Iris.csv que se encuentra en https://github.com/jcromerohdz/iris, elaborar la limpieza de datos necesaria para ser procesado por el siguiente algoritmo (Importante, esta limpieza debe ser por medio de un script de Scala en Spark).
#### a. Utilice la librería Mllib de Spark el algoritmo de Machine Learning Multilayer Perceptron Classifier

Revisar el archivo en la siguiente ruta para validar el codigo: https://github.com/GalileaJarillo/ClaseBigData/tree/feature/unit2-christian/Unit%202/Evaluation%20Practice

### 2. ¿Cuáles son los nombres de las columnas?
```
scala> data.columns
```
```sh
res2: Array[String] = Array(sepal_length, sepal_width, petal_length, petal_width, species)
```
### 3. ¿Cómo es el esquema?
```
scala> data.printSchema()
```
```sh
root
 |-- sepal_length: double (nullable = true)
 |-- sepal_width: double (nullable = true)
 |-- petal_length: double (nullable = true)
 |-- petal_width: double (nullable = true)
 |-- species: string (nullable = true)
```
### 4. Imprime las primeras 5 columnas.
```
scala> data.show(5)
```
```sh
+------------+-----------+------------+-----------+-------+
|sepal_length|sepal_width|petal_length|petal_width|species|
+------------+-----------+------------+-----------+-------+
|         5.1|        3.5|         1.4|        0.2| setosa|
|         4.9|        3.0|         1.4|        0.2| setosa|
|         4.7|        3.2|         1.3|        0.2| setosa|
|         4.6|        3.1|         1.5|        0.2| setosa|
|         5.0|        3.6|         1.4|        0.2| setosa|
+------------+-----------+------------+-----------+-------+
```
### 5. Usa el método describe () para aprender más sobre los datos del DataFrame.
```
scala> data.describe().show()
```
```sh
+-------+------------------+-------------------+------------------+------------------+---------+
|summary|      sepal_length|        sepal_width|      petal_length|       petal_width|  species|
+-------+------------------+-------------------+------------------+------------------+---------+
|  count|               150|                150|               150|               150|      150|
|   mean| 5.843333333333335| 3.0540000000000007|3.7586666666666693|1.1986666666666672|     NULL|
| stddev|0.8280661279778637|0.43359431136217375| 1.764420419952262|0.7631607417008414|     NULL|
|    min|               4.3|                2.0|               1.0|               0.1|   setosa|
|    max|               7.9|                4.4|               6.9|               2.5|virginica|
+-------+------------------+-------------------+------------------+------------------+---------+
```
### 6. Haga la transformación pertinente para los datos categóricos los cuales serán nuestras etiquetas a clasificar.
```
[code]
```
```sh
[results]
```
### 7. Construya el modelo de clasificación y explique su arquitectura.
```
[code]
```
```sh
[results]
```
### 8. Imprima los resultados del modelo y de sus observaciones.
```
[code]
```
```sh
[results]
```
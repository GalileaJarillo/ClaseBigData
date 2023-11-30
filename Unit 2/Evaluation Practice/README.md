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
val iris = data.withColumn("sepal_length", col("sepal_length").cast("Double")).withColumn("sepal_width", col("sepal_width").cast("Double")).withColumn("petal_length", col("petal_length").cast("Double")).withColumn("petal_width", col("petal_width").cast("Double"))

val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")

val features = assembler.transform(iris)

val indexerLabel = new StringIndexer().setInputCol("species").setOutputCol("indexedLabel").fit(features)

val indexerFeatures = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4)

val Array(training, test) = features.randomSplit(Array(0.7, 0.3), seed = 12345)  
```
### 7. Construya el modelo de clasificación y explique su arquitectura.
Se utilizó Multilayer Perceptron Classifier, para transformar un conjunto de datos de prueba, generando predicciones y otros resultados.  Para construir y entrenar un el modelo se realizó un proceso donde se crearon indexes para manipular el entrenamiento, se utilizaron etiquetas para interpretar de las predicciones del modelo.

```
val layers = Array[Int](4, 5, 4, 3)

val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setBlockSize(128).setSeed(12345).setMaxIter(100)

val converterLabel = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(indexerLabel.labels)

val pipeline = new Pipeline().setStages(Array(indexerLabel, indexerFeatures, trainer, converterLabel))

val model = pipeline.fit(training)
val results = model.transform(test)

results.show()
```
```sh
+------------+-----------+------------+-----------+----------+-----------------+------------+-----------------+--------------------+--------------------+----------+--------------+
|sepal_length|sepal_width|petal_length|petal_width|   species|         features|indexedLabel|  indexedFeatures|       rawPrediction|         probability|prediction|predictedLabel|
+------------+-----------+------------+-----------+----------+-----------------+------------+-----------------+--------------------+--------------------+----------+--------------+
|         4.6|        3.2|         1.4|        0.2|    setosa|[4.6,3.2,1.4,0.2]|         0.0|[4.6,3.2,1.4,0.2]|[20.5696904244622...|[0.99999999999996...|       0.0|        setosa|
|         4.8|        3.1|         1.6|        0.2|    setosa|[4.8,3.1,1.6,0.2]|         0.0|[4.8,3.1,1.6,0.2]|[20.5796581319746...|[0.99999999999997...|       0.0|        setosa|
|         4.9|        2.5|         4.5|        1.7| virginica|[4.9,2.5,4.5,1.7]|         2.0|[4.9,2.5,4.5,1.7]|[-15.941942979510...|[3.48383627239737...|       1.0|    versicolor|
|         5.0|        3.0|         1.6|        0.2|    setosa|[5.0,3.0,1.6,0.2]|         0.0|[5.0,3.0,1.6,0.2]|[20.5867995218890...|[0.99999999999997...|       0.0|        setosa|
|         5.0|        3.2|         1.2|        0.2|    setosa|[5.0,3.2,1.2,0.2]|         0.0|[5.0,3.2,1.2,0.2]|[20.5691331140208...|[0.99999999999996...|       0.0|        setosa|
|         5.0|        3.5|         1.3|        0.3|    setosa|[5.0,3.5,1.3,0.3]|         0.0|[5.0,3.5,1.3,0.3]|[20.5691247488477...|[0.99999999999996...|       0.0|        setosa|
|         5.1|        3.5|         1.4|        0.3|    setosa|[5.1,3.5,1.4,0.3]|         0.0|[5.1,3.5,1.4,0.3]|[20.5691998172845...|[0.99999999999996...|       0.0|        setosa|
|         5.4|        3.4|         1.5|        0.4|    setosa|[5.4,3.4,1.5,0.4]|         0.0|[5.4,3.4,1.5,0.4]|[20.5700985640034...|[0.99999999999996...|       0.0|        setosa|
|         5.4|        3.9|         1.3|        0.4|    setosa|[5.4,3.9,1.3,0.4]|         0.0|[5.4,3.9,1.3,0.4]|[20.5690921355843...|[0.99999999999996...|       0.0|        setosa|
|         5.7|        2.8|         4.1|        1.3|versicolor|[5.7,2.8,4.1,1.3]|         1.0|[5.7,2.8,4.1,1.3]|[-15.941942984485...|[3.48383624522684...|       1.0|    versicolor|
|         5.7|        4.4|         1.5|        0.4|    setosa|[5.7,4.4,1.5,0.4]|         0.0|[5.7,4.4,1.5,0.4]|[20.5690897527175...|[0.99999999999996...|       0.0|        setosa|
|         5.8|        4.0|         1.2|        0.2|    setosa|[5.8,4.0,1.2,0.2]|         0.0|[5.8,4.0,1.2,0.2]|[20.5690885975164...|[0.99999999999996...|       0.0|        setosa|
|         6.0|        2.9|         4.5|        1.5|versicolor|[6.0,2.9,4.5,1.5]|         1.0|[6.0,2.9,4.5,1.5]|[-15.941942985886...|[3.48383623757184...|       1.0|    versicolor|
|         6.1|        2.6|         5.6|        1.4| virginica|[6.1,2.6,5.6,1.4]|         2.0|[6.1,2.6,5.6,1.4]|[-15.941942986564...|[3.48383623387004...|       1.0|    versicolor|
|         6.1|        2.9|         4.7|        1.4|versicolor|[6.1,2.9,4.7,1.4]|         1.0|[6.1,2.9,4.7,1.4]|[-15.941942986214...|[3.48383623578313...|       1.0|    versicolor|
|         6.2|        2.2|         4.5|        1.5|versicolor|[6.2,2.2,4.5,1.5]|         1.0|[6.2,2.2,4.5,1.5]|[-15.941942985555...|[3.48383623938183...|       1.0|    versicolor|
|         6.2|        2.9|         4.3|        1.3|versicolor|[6.2,2.9,4.3,1.3]|         1.0|[6.2,2.9,4.3,1.3]|[-15.941942986044...|[3.48383623670837...|       1.0|    versicolor|
|         6.2|        3.4|         5.4|        2.3| virginica|[6.2,3.4,5.4,2.3]|         2.0|[6.2,3.4,5.4,2.3]|[-15.941942986709...|[3.48383623307955...|       1.0|    versicolor|
|         6.4|        2.8|         5.6|        2.2| virginica|[6.4,2.8,5.6,2.2]|         2.0|[6.4,2.8,5.6,2.2]|[-15.941942986715...|[3.48383623304552...|       1.0|    versicolor|
|         6.4|        3.1|         5.5|        1.8| virginica|[6.4,3.1,5.5,1.8]|         2.0|[6.4,3.1,5.5,1.8]|[-15.941942986780...|[3.48383623268959...|       1.0|    versicolor|
+------------+-----------+------------+-----------+----------+-----------------+------------+-----------------+--------------------+--------------------+----------+--------------+
```
### 8. Imprima los resultados del modelo y de sus observaciones.
Para evaluar el modelo se utiliza pipeline que engloba el setup, se crea un evaluador de clasificación multiclase y para calcular la precisión del mismo se usa accuracy. Para finalizar y calcular la precisión del modelo se imprime el resultado, y se evalía a través de prediction e indexed label.

```
val model = pipeline.fit(training)
val results = model.transform(test)
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
```
```sh
println(s"Prueba de Precision = ${evaluator.evaluate(results.select("prediction", "indexedLabel"))}")
```
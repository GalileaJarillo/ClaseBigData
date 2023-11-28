
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val data  = spark.read.option("header","true").option("inferSchema", "true").csv("bank-full.csv")

data.printSchema()

val bank = data.drop("age","marital","education","default","housing","loan","contact","day","month","duration","campaign","pdays","previous","poutcome","y")

val newBank = bank.withColumn("balance", col("balance").cast("Double")).withColumn("marital2", col("marital2").cast("Double")).withColumn("education2", col("education2").cast("Double")).withColumn("contact2", col("contact2").cast("Double"))

import org.apache.spark.ml.feature.VectorAssembler
val assembler = new VectorAssembler().setInputCols(Array("marital2","balance","education2","contact2")).setOutputCol("features")

val features = assembler.transform(newBank)

val indexerLabel = new StringIndexer().setInputCol("job").setOutputCol("indexedLabel").fit(features)

val indexerFeatures = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4)

val Array(training, test) = features.randomSplit(Array(0.7, 0.3), seed = 12345)  

val layers = Array[Int](4, 5, 4, 3)

val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setBlockSize(128).setSeed(12345).setMaxIter(100)

val converterLabel = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(indexerLabel.labels)

val pipeline = new Pipeline().setStages(Array(indexerLabel, indexerFeatures, trainer, converterLabel))

val model = pipeline.fit(training)
val results = model.transform(test)
results.show()

val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

println(s"Prueba de Precision = ${evaluator.evaluate(results.select("prediction", "indexedLabel"))}")

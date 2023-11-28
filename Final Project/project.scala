import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.Pipeline

val spark = SparkSession.builder().getOrCreate()
val data  = spark.read.option("header","true").option("inferSchema", "true").csv("bank-full.csv")

data.columns.foreach(println)
data.printSchema()
data.show(5)
data.describe().show()

val bank = data.withColumn("age", col("age").cast("Double")).withColumn("balance", col("balance").cast("Double")).withColumn("marital2", col("marital2").cast("Double")).withColumn("education2", col("education2").cast("Double")).withColumn("poutcome2", col("poutcome2").cast("Double"))

bank.printSchema()



// No sabemos si lo ocupamos...
// val assembler = new VectorAssembler().setInputCols(Array("age","marital2","balance","education2","poutcome2")).setOutputCol("features")

// val features = assembler.transform(bank)

// features.printSchema()


// val indexerLabel = new StringIndexer().setInputCol("job").setOutputCol("indexedLabel").fit(features)

// val indexerFeatures = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4)

// val Array(training, test) = features.randomSplit(Array(0.7, 0.3), seed = 12345)  

// val layers = Array[Int](4, 5, 4, 3)

// val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setBlockSize(128).setSeed(12345).setMaxIter(100)


// val converterLabel = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(indexerLabel.labels)

// val pipeline = new Pipeline().setStages(Array(indexerLabel, indexerFeatures, trainer, converterLabel))

// val model = pipeline.fit(training)
// val results = model.transform(test)
// results.show()

// val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

// println(s"Prueba de Precision = ${evaluator.evaluate(results.select("prediction", "indexedLabel"))}")

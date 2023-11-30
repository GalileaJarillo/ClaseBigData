import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.Pipeline

val spark = SparkSession.builder().getOrCreate()

// Load the dataset
val data = spark.read.option("header", "true").option("inferSchema", "true").csv("bank-full.csv")

// Selecting relevant columns and transforming categorical columns to numerical using StringIndexer
val features = data.select("age","job","marital","education","default","balance","housing","loan","day","month","duration","campaign","pdays","previous", "y")

// Assemble features into a vector column
val assembler = new VectorAssembler()
    .setInputCols(Array("age","job","marital","education","default","balance","housing","loan","day","month","duration","campaign","pdays","previous"))
    .setOutputCol("features")

val features = assembler.transform(data)

val indexerLabel = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(features)

val indexerFeatures = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(14)

// Split the data using different seeds 10 times
val Array(trainData, testData) = features.randomSplit(Array(0.7, 0.3), seed = 1234L)

// Define the layers for the neural network
val layers = Array[Int](14, 5, 2, 2)

// Create the MultilayerPerceptronClassifier
val mlp = new MultilayerPerceptronClassifier()
.setLayers(layers)
.setLabelCol("indexedLabel")
.setBlockSize(128)
.setSeed(1234L)
.setMaxIter(100)


val converterLabel = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(indexerLabel.labels)

val pipeline = new Pipeline().setStages(Array(indexerLabel, indexerFeatures, mlp, converterLabel))


// Then proceed with the model fitting
val model = pipeline.fit(trainData)

// Make predictions on the test data
val predictions = model.transform(testData)

// Evaluate the model
val evaluator = new MulticlassClassificationEvaluator()
.setLabelCol("label")
.setPredictionCol("prediction")
.setMetricName("accuracy")
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

val accuracy = evaluator.evaluate(predictions)

println(s"Test = ${accuracy}")
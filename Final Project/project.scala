import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{StringIndexer, VectorAssembler}
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

// Load the dataset
val data = spark.read.option("header", "true").option("inferSchema", "true").csv("bank-full.csv")

val selectedData = data.select(
  col("age").cast("double"),
  col("job"),
  col("marital"),
  col("education"),
  col("balance").cast("double"),
  col("day").cast("double"),
).toDF("age", "job", "marital", "education", "balance", "day")

// Selecting relevant columns and transforming categorical columns to numerical using StringIndexer
val selectedData = data.select("age", "job", "marital", "education", "balance", "day")
val indexer = new StringIndexer().setInputCol("job").setOutputCol("label")
val indexedData = indexer.fit(selectedData).transform(selectedData)

// Assemble features into a vector column
val assembler = new VectorAssembler()
    .setInputCols(Array("age", "balance", "day"))
    .setOutputCol("features")

val assembledData = assembler.transform(indexedData)

// Split the data using different seeds 10 times
val Array(trainData, testData) = assembledData.randomSplit(Array(0.99, 0.01), seed = 1234L)

// Define the layers for the neural network
val layers = Array[Int](4, 5, 4, 3)

// Create the MultilayerPerceptronClassifier
val mlp = new MultilayerPerceptronClassifier()
.setLayers(layers)
.setBlockSize(128)
.setSeed(1234L)
.setMaxIter(100)

// Assuming 'label' is your target column and you want to convert it to binary labels
val processedData = assembledData.withColumn("label", when(col("label") === 10.0, 1.0).otherwise(0.0))

// Then proceed with the model fitting
val model = mlp.fit(processedData)

// Make predictions on the test data
val predictions = model.transform(testData)

// Evaluate the model
val evaluator = new MulticlassClassificationEvaluator()
.setLabelCol("label")
.setPredictionCol("prediction")
.setMetricName("accuracy")

println(s"Test = ${evaluator.evaluate(predictions.select("prediction", "label"))}")


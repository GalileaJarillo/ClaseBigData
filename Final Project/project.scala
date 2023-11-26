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

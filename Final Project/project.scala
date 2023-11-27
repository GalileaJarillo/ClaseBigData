import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
val data = spark.read.option("header", "true").option("inferSchema", "true").format("csv").load("bank-full.csv")

data.columns.foreach(println)
data.printSchema()
data.show(10)
data.describe().show()


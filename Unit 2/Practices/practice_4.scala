////////////////////////////////////////////
///  Multilayer Perceptron Classifier   ///
///                                    ///
/////////////////////////////////////////


import org.apache.spark.ml.classification.LinearSVC

// Load training data
val training = spark.read.format("libsvm").load("sample_libsvm_data.txt")

val lsvc = new LinearSVC()
  .setMaxIter(10)
  .setRegParam(0.1)

// Fit the model
val lsvcModel = lsvc.fit(training)

// Print the coefficients and intercept for linear svc
println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")
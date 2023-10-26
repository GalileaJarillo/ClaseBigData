/* Assigment 6 / Practice 6
Implemente los siguientes seudocódigos de la serie Fibonacci en Scala de la liga proporcionada:

Algoritmo 1,
Algoritmo 3,
Algoritmo 4,
Algoritmo 5

https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci
*/

// Task 1
def fib(n: Int): Int = {
  if (n < 2) {
    return n
  } else {
    return fib(n - 1) + fib(n - 2)
  }
}
val result = fib(5)
println(result)

// Task 3
def fib(n: Int): Int = {
  if (n == 0) {
    return 0
  } else if (n == 1) {
    return 1
  } else {
    var a = 0
    var b = 1
    var c = 0
    for (k <- 2 to n) {
      c = a + b
      a = b
      b = c
    }
    return b
  }
}
val result = fib(5)
println(result)

// Task 4
def fib(n: Int): Int = {
  if (n == 0) {
    return 0
  } else if (n == 1) {
    return 1
  } else {
    var a = 0
    var b = 1
    for (k <- 2 to n) {
      val temp = b
      b = b + a
      a = temp - a
    }
    return a
  }
}
val result = fib(1)
println(result)

// Task 5
def fib(n: Int): Int = {
  if (n < 2) {
    return n
  } else {
    val vector = new Array[Int](n + 1)
    vector(0) = 0
    vector(1) = 1

    for (k <- 2 to n) {
      vector(k) = vector(k - 1) + vector(k - 2)
    }

    return vector(n)
  }
}
val result = fib(10)
println(result)

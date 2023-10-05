// Assessment 1/Practica 1
//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
//2. Desarrollar un algoritmo en scala que me diga si un numero es primo
//3. Dada la variable bird = "tweet", utiliza interpolacion de string para
//   imprimir "Estoy ecribiendo un tweet"
//4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
//   secuencia "Luke"
//5. Cual es la diferencia entre value y una variable en scala?
//6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416 

// Team 1 - Christian Gandarilla && Galilea Jarillo
// Task 1
val pi = 3.1416
val circle = pi * math.pow(4, 2)
// println(s"Radio es: $circle")

// Task 2
def isEven(num: Int): Boolean = {
    if (num <= 1) {
        false
    } else if (num <= 3) {
        true
    } else if (num % 2 == 0 || num % 3 == 0) {
        false
    } else {
        var i = 5
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false
            }
            i += 6
        }
        true
    }
}
  
val num = 18
if (isEven(num)) {
    println(s"$num es primo.")
} else {
    println(s"$num no es primo.")
}
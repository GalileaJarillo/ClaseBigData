This repo could be to show practices for Big Data

<!-- Christian Gandarilla --> 

Hello there
 <!-- Galilea Jarillo --> 
 #Unit1 Practice 1
### Desarrollar un algoritmo en scala que calcule el radio de un circulo
```
val pi = 3.1416
val circle = pi * math.pow(4, 2)
println(s"Radio es: $circle")
```
```sh
pi: Double = 3.1416
circle: Double = 50.2656
Radio es: 50.2656
```

#Unit1 Practice 2
### Desarrollar un algoritmo en scala que me diga si un numero es primo
```
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
  
val num = 18 //This could be different
if (isEven(num)) {
    println(s"$num es primo.")
} else {
    println(s"$num no es primo.")
}
```
```sh
isEven: (num: Int)Boolean
num: Int = 18
18 no es primo.
```
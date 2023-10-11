# Unit 1 Practice 1
## This repo could be to show practices for Big Data
### Team 1:
### Christian Gandarilla && Galilea Jarillo

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


### Dada la variable bird = "tweet", utiliza interpolacion de string para imprimir "Estoy escribiendo un tweet"
``` 
val bird = "tweet"
println(s"estoy escribiendo un $bird")
``` 
``` sh
val bird: String = tweet
estoy escribiendo un tweet
``` 
### Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la //   secuencia "Luke"
``` 
var message = "Hola Luke soy tu padre!"
message = message.slice(5,9)
println(s"Hola $message")
``` 
``` sh
var message: String = Hola Luke soy tu padre!
// mutated message
Hola Luke
``` 

### Cual es la diferencia entre value y una variable en scala?
``` 
println("La variable es mutable, mientras que un value no lo es.")
``` 
``` sh
La variable es mutable, mientras que un value no lo es.
``` 

### Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416 
``` 
var list = (2,4,5,1,2,3,3.1416,23)
val pi = list._7
println(s"Pi = $pi")
``` 
``` sh
list: (Int, Int, Int, Int, Int, Int, Double, Int) = (2,4,5,1,2,3,3.1416,23)
pi: Double = 3.1416
Pi = 3.1416
``` 

# Unit 1 Practice 2
### Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
```val list = List("rojo","blanco","negro")
```
```sh
```val list: List[String] = List(rojo, blanco, negro)
List(rojo, blanco, negro)

### Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
```val newList = list:+"verde":+"amarillo":+"naranja":+"perla"
```
```sh
```val newList: List[String] = List(rojo, blanco, negro, verde, amarillo, naranja, perla)

### Traer los elementos de "lista" "verde", "amarillo", "azul"
```
```newList slice (3,6)
```sh
```val res26: List[String] = List(verde, amarillo, naranja)

### Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
```
```
```sh
```

### Cuales son los elementos únicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversión a conjuntos
```
```
```sh
```

### Crea una mapa mutable llamado nombres que contenga los siguiente: "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
```
```
```sh
```

### a . Imprime todas la llaves del mapa
```
```
```sh
```

### b . Agrega el siguiente valor al mapa("Miguel", 23)
```
```
```sh
```
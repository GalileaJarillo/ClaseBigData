# Unit I
## Practice 3
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

## Practice 4
### Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
```
val list = List("rojo","blanco","negro")
```
```sh
val list: List[String] = List(rojo, blanco, negro)
List(rojo, blanco, negro)
```

### Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
```
val newList = list:+"verde":+"amarillo":+"naranja":+"perla"
```
```sh
val newList: List[String] = List(rojo, blanco, negro, verde, amarillo, naranja, perla)
```

### Traer los elementos de "lista" "verde", "amarillo", "azul"
```
newList slice (3,6)
```
```sh
val res26: List[String] = List(verde, amarillo, naranja)
```

### Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
```
val array = Array.range(1,1000,5)
```
```sh
array: Array[Int] = Array(1, 6, 11, 16, 21, 26, 31, 36, 41, 46, 51, 56, 61, 66, 71, 76, 81, 86, 91, 96, 101, 106, 111, 116, 121, 126, 131, 136, 141, 146, 151, 156, 161, 166, 171, 176, 181, 186, 191, 196, 201, 206, 211, 216, 221, 226, 231, 236, 241, 246, 251, 256, 261, 266, 271, 276, 281, 286, 291, 296, 301, 306, 311, 316, 321, 326, 331, 336, 341, 346, 351, 356, 361, 366, 371, 376, 381, 386, 391, 396, 401, 406, 411, 416, 421, 426, 431, 436, 441, 446, 451, 456, 461, 466, 471, 476, 481, 486, 491, 496, 501, 506, 511, 516, 521, 526, 531, 536, 541, 546, 551, 556, 561, 566, 571, 576, 581, 586, 591, 596, 601, 606, 611, 616, 621, 626, 631, 636, 641, 646, 651, 656, 661, 666, 671, 676, 681, 686, 691, 696, 701, 706, 711, 716, 721, 726, 731, 736, 741, 746, 751, 756, 761, 766, 771, 776, 781, 786, 791...)
```

### Cuales son los elementos únicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversión a conjuntos
```
val list = List(1,3,3,4,6,7,3,7)
list.distinct
```
```sh
list: List[Int] = List(1, 3, 3, 4, 6, 7, 3, 7)
res139: List[Int] = List(1, 3, 4, 6, 7)
```

### Crea una mapa mutable llamado nombres que contenga los siguiente: "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
```
var names = Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", 27))
```
```sh
names: scala.collection.immutable.Map[String,Int] = Map(Jose -> 20, Luis -> 24, Ana -> 23, Susana -> 27)
```

#### a . Imprime todas la llaves del mapa
```
println(names.keys)
```
```sh
Set(Jose, Luis, Ana, Susana)
```

#### b . Agrega el siguiente valor al mapa("Miguel", 23)
```
names += ("Miguel" -> 23)
println(names.keys)
```
```sh
Set(Ana, Miguel, Luis, Jose, Susana)
```

## Practice 5
### listEvens
```
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}

val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
listEvens(l)
listEvens(l2)
```
```sh
Esta variable define en lista a los números que sea par o impar 
```

### Afortunado
```
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}

val af= List(1,7,7)
println(afortunado(af))
```
```sh
Esta función recorre una lista suma todos los elementos, pero cuando encuentra un 7, suma 14 en su lugar. El resultado final es la suma modificada de los elementos de la lista.
```

### Balance
```
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0

    segunda = list.sum

    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)

        if(primera == segunda){
            return true
        }
    }
    return false 
}

val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)

balance(bl)
balance(bl2)
balance(bl3)
```
```sh
Compara los valores de la lista para saber si esta esta balanceada, es decir que pueda dividirse en 2 partes iguales.
```

### Palíndromo
```
def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))
```
```sh
Esta función comprueba si el string que se inserta es un palíndromo, es decir se escribe igual de izquierda a derecha que de derecha a izquierda.
```

## Practice 6
### Wikipedia Algoritmos. Estos algoritmos describen la sucesión fibonacci
´´´
def fib(n: Int): Int = {
  if (n < 2) {
    return n
  } else {
    return fib(n - 1) + fib(n - 2)
  }
}
val result = fib(5)
println(result)
´´´
´´´sh
Este algoritmo demuestra la simplicidad de la sucesión fibonacci siempre y cuando el algoritmo efectua f_{{n+1}}-1 sumas para poder encontrar el resultado.
´´´
´´´
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
´´´
´´´sh
Los tres algoritmos anteriores expresan de otra manera la secuencia fibonacci
´´´

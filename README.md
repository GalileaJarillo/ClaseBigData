# This repo could be to show practices for Big Data
# Team 1: Christian Gandarilla && Galilea Jarillo

# Unit 1 Practice 3
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

# Unit 1 Practice 4
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

# Unit 1 Practice 5
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

# Unit 1 Practice 6
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

# Examen Unidad I
### 1. Comienza una simple sesión Spark.
```
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
```

### 2. Cargue el archivo Netflix Stock CSV en dataframe llamado df, haga que Spark infiera los tipos de datos.
```
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")
```

### 3. ¿Cuáles son los nombres de las columnas?
Date, Open, High, Low, Close, Volume, Adj Close

#### 4. ¿Cómo es el esquema?
```
scala> df.printSchema()
```
```sh
root
 |-- Date: date (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
 |-- Adj Close: double (nullable = true)
```

### 5. Imprime las primeras 5 renglones.
```
scala> df.show(5)
scala> df.head(5)
```

### 6. Usa el método describe () para aprender sobre el DataFrame.
```
scala> df.describe().show()
```
```sh
WARN SparkStringUtils: Truncated the string representation of a plan since it was too large. This behavior can be adjusted by setting 'spark.sql.debug.maxToStringFields'.+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|summary|              Open|              High|               Low|             Close|              Volume|         Adj Close|
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|  count|              1259|              1259|              1259|              1259|                1259|              1259|
|   mean|230.39351086656092|233.97320872915006|226.80127876251044|  230.522453845909|2.5634836060365368E7|55.610540036536875|
| stddev|164.37456353264244| 165.9705082667129| 162.6506358235739|164.40918905512854| 2.306312683388607E7|35.186669331525486|
|    min|         53.990001|         55.480001|             52.81|              53.8|             3531300|          7.685714|
|    max|        708.900017|        716.159996|        697.569984|        707.610001|           315541800|        130.929993|
+-------+------------------+-------
```

### 7. Crea un nuevo Dataframe a partir del df creado anteriormente llamdo “HVRatio” para crear una columna nueva llamada “HV Ratio” que es la relación que existe entre el precio de la columna “High” frente a la columna “Volumen” de acciones negociadas por un día. Hint - es una operación
```
val HVRatio = df.withColumn("HV Ratio", (df("High") / df("Volume")))
scala> HVRatio.show(5)
```
```sh
+----------+----------+------------------+----------+-----------------+---------+------------------+--------------------+
|      Date|      Open|              High|       Low|            Close|   Volume|         Adj Close|            HV Ratio|
+----------+----------+------------------+----------+-----------------+---------+------------------+--------------------+
|2011-10-24|119.100002|120.28000300000001|115.100004|       118.839996|120460200|         16.977142|9.985040951285156E-7|
|2011-10-25| 74.899999|         79.390001| 74.249997|        77.370002|315541800|11.052857000000001|2.515989989281927E-7|
|2011-10-26|     78.73|         81.420001| 75.399997|        79.400002|148733900|         11.342857|5.474206014903126E-7|
|2011-10-27| 82.179998| 82.71999699999999| 79.249998|80.86000200000001| 71190000|11.551428999999999|1.161960907430818...|
|2011-10-28| 80.280002|         84.660002| 79.599999|84.14000300000001| 57769600|             12.02|1.465476686700271...|
+----------+----------+------------------+----------+-----------------+---------+------------------+--------------------+
```

### 8. ¿Qué día tuvo el pico más alto en la columna “Open”?
```
scala> df.orderBy(desc("Open")).first()
scala> df.orderBy(desc("Open")).show(1)
```
```sh
+----------+----------+----------+----------+----------+--------+----------+
|      Date|      Open|      High|       Low|     Close|  Volume| Adj Close|
+----------+----------+----------+----------+----------+--------+----------+
|2015-07-14|708.900017|711.449982|697.569984|702.600006|19736500|100.371429|
```

### 9. ¿Cuál es el significado de la columna Cerrar “Close” en el contexto de información financiera, explíquelo no hay que codificar nada?
Consideramos que se refiere al precio de cierre de cada una de las fechas determinadas respecto a los datos proporcionados en la tabla. El precio de cierre es uno de los valores más importantes y ampliamente seguidos en el mundo de las finanzas y se utiliza en una variedad de análisis y cálculos.

### 10. ¿Cuál es el máximo y mínimo de la columna “Volumen”?
```
scala> df.agg(max("Volume")).show()
```
```sh
+-----------+
|max(Volume)|
+-----------+
|  315541800|
+-----------+
```
```
scala> df.agg(min("Volume")).show()
```
```sh
+-----------+
|min(Volume)|
+-----------+
|    3531300|
+-----------+
```

### 11. Con Sintaxis Scala/Spark $ conteste lo siguiente:
#### a) ¿Cuántos días fue la columna “Close” inferior a $ 600?
```
scala> df.filter("Close < 600").count()
```
```sh
res96: Long = 1218
```
#### b) ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
```
val totalRows = df.count()
val greaterRows = df.filter("High > 500").count()
scala> (greaterRows.toDouble / totalRows) * 100 
```
```sh
val res1: Double = 4.924543288324067
```

#### c) ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?
```
scala> df.select(corr("High", "Volume")).show()
```
```sh
+--------------------+
|  corr(High, Volume)|
+--------------------+
|-0.20960233287942157|
+--------------------+
```
#### d) ¿Cuál es el máximo de la columna “High” por año?
```
scala> df.groupBy(year(col("Date")).alias("Year")).agg(max("High").alias("MaxHigh")).show()
```
```sh
+----+------------------+
|Year|           MaxHigh|
+----+------------------+
|2015|        716.159996|
|2013|        389.159988|
|2014|        489.290024|
|2012|        133.429996|
|2016|129.28999299999998|
|2011|120.28000300000001|
+----+------------------+
```

#### e) ¿Cuál es el promedio de la columna “Close” para cada mes del calendario?
```
scala> df.groupBy(year(col("Date")).alias("Year"), month(col("Date")).alias("Month")).agg(avg("Close").alias("AvgClose")).orderBy(desc("Year"
)).show()
```
```sh
+----+-----+------------------+
|Year|Month|          AvgClose|
+----+-----+------------------+
|2016|    7| 93.16349985000002|
|2016|    5| 93.17476147619047|
|2016|    2| 89.96950000000001|
|2016|    9| 97.44857128571428|
|2016|   10|    109.0562500625|
|2016|    6| 94.29863663636364|
|2016|    1|105.44789489473683|
|2016|    4|100.81190457142858|
|2016|    8| 95.62260904347829|
|2016|    3| 99.31590927272727|
|2015|   12|121.29636322727274|
|2015|    7|339.94727122727267|
|2015|   11|116.06949959999997|
|2015|    8|117.50285638095235|
|2015|    4| 505.8238118095239|
|2015|    2| 462.9221038421052|
|2015|    9|100.56571519047618|
|2015|   10|105.58772759090908|
|2015|    3|437.66090550000007|
|2015|    6| 652.4349957727273|
+----+-----+------------------+
only showing top 20 rows
```

##### Ordenado por año
```
scala> df.groupBy(year(col("Date")).alias("Year"), month(col("Date")).alias("Month")).agg(avg("Close").alias("AvgClose")).orderBy(desc("Year"
)).show()
```
```sh
+----+-----+------------------+
|Year|Month|          AvgClose|
+----+-----+------------------+
|2016|    7| 93.16349985000002|
|2016|    5| 93.17476147619047|
|2016|    2| 89.96950000000001|
|2016|    9| 97.44857128571428|
|2016|   10|    109.0562500625|
|2016|    6| 94.29863663636364|
|2016|    1|105.44789489473683|
|2016|    4|100.81190457142858|
|2016|    8| 95.62260904347829|
|2016|    3| 99.31590927272727|
|2015|   12|121.29636322727274|
|2015|    7|339.94727122727267|
|2015|   11|116.06949959999997|
|2015|    8|117.50285638095235|
|2015|    4| 505.8238118095239|
|2015|    2| 462.9221038421052|
|2015|    9|100.56571519047618|
|2015|   10|105.58772759090908|
|2015|    3|437.66090550000007|
|2015|    6| 652.4349957727273|
+----+-----+------------------+
only showing top 20 rows
```



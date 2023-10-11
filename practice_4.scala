/* Assigment 4 / Practice 4
Desarrollar los siguientes puntos con lenguaje Scala y seguir el Git Flow Básico con su compañero de equipo:
1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
3. Traer los elementos de "lista" "verde", "amarillo", "azul"
4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
5. Cuales son los elementos únicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversión a conjuntos
6. Crea una mapa mutable llamado nombres que contenga los siguiente
     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
6 a . Imprime todas la llaves del mapa
6 b . Agrega el siguiente valor al mapa("Miguel", 23)
*/

// Task 1
val list = List("rojo","blanco","negro")

// Task 2 
val newList = list:+"verde":+"amarillo":+"naranja":+"perla"

// Task 3
newList slice (3,6)

// Task 4
val array = Array.range(1,1000,5)

// Task 5
val list = List(1,3,3,4,6,7,3,7)
list.distinct

// Task 6
var names = Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", 27))

// Task 6 - a
println(names.keys)

// Task 6 - b
names += ("Miguel" -> 23)
println(names.keys)
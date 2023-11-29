<h1 align="center">UNIVERSIDAD AUTÓNOMA DE BAJA CALIFORNIA</h1>

<h2 align="center">FACULTAD DE CONTADURÍA Y ADMINISTRACIÓN</h2>

<p align="center">
  <img src="/Final Project/uabc_logo.png" alt="Escudo de la UABC">
</p>

<h3 align="center">MAESTRÍA EN GESTIÓN DE LAS TECNOLOGÍAS DE LA INFORMACIÓN Y LA COMUNICACIÓN</h3>

<h4 align="center">BIG DATA</h4>

<p align="center">DR. JOSÉ CHRISTIAN ROMERO HERNÁNDEZ</p>

<p align="center"><strong>EQUIPO 1</strong></p>

<p align="center">
  <em>
    Fernando Christian Gandarilla Carrillo <br>
    Galilea Jarillo Dávila
  </em>
</p>

---

# PROYECTO FINAL

## COMPARACIÓN DE RENDIMIENTO DEL ALGORITMO MULTILAYER PERCEPTRON CLASSIFIER

---

## Índice

1. [Introducción](#introducción)
2. [Implementación](#implementación)
3. [Resultados](#resultados)
4. [Conclusiones](#conclusiones)

---

## Introducción

El objetivo de este proyecto es comparar el rendimiento del algoritmo de machine learning Multilayer Perceptron Classifier al cambiar el seed de aleatoridad en la fase de separación de datos (randomSplit) 10 veces. Utilizamos como fuente de datos el conjunto de datos del [Bank Marketing](https://archive.ics.uci.edu/ml/datasets/Bank+Marketing).

---

## Implementación

Para este proyecto, elegimos utilizar Spark con Scala debido a su capacidad para procesar grandes volúmenes de datos de manera distribuida y eficiente. Spark proporciona las funcionalidades necesarias para realizar tareas de procesamiento y modelado de datos de manera escalable.

---

## Resultados

Realizamos 10 corridas del algoritmo Multilayer Perceptron Classifier cambiando el seed de aleatoridad en la fase de separación de datos. A continuación se presenta una tabla con los datos de precisión de cada corrida y el promedio de su desempeño:

| Corrida|                Comando de prueba              |         Precisión        |
|--------|-----------------------------------------------|--------------------------|
|   1    |  randomSplit(Array(0.1, 0.9), seed = 12345)   |   0.21474595445378977    |
|   2    |  randomSplit(Array(0.7, 0.3), seed = 22245)   |   0.21788666319160027    |
|   3    |  randomSplit(Array(0.2, 0.8), seed = 12345)   |   0.2154008263316973     |
|   4    |  randomSplit(Array(0.25, 0.75), seed = 78951) |   0.21487261334752025    |
|   5    |  randomSplit(Array(0.33, 0.67), seed = 45456) |   0.21387054161162483    |
|   6    |  randomSplit(Array(0.4, 0.6), seed = 63888)   |   0.21485155845117346    |
|   7    |  randomSplit(Array(0.5, 0.5), seed = 12345)   |   0.21506988228032273    |
|   8    |  randomSplit(Array(0.7, 0.3), seed = 22244)   |   0.215161502966381      |
|   9    |  randomSplit(Array(0.73, 0.27), seed = 89775) |   0.21023240535435658    |
|   10   |  randomSplit(Array(0.99, 0.01), seed = 1234L) |   0.21171171171171171    |
|        |                                 **Promedio**  |        **0.214**         |

---

## Conclusiones

_(Resumen de los resultados, posibles implicaciones, limitaciones del estudio y conclusiones finales del proyecto)_
Según Mlib, (MLPC) es un clasificador basado en la red neuronal artificial y consta de varias capas de nodos. Cada capa está completamente conectada a la siguiente capa de la red. Si bien realizar el set up para realizar el ejercicio fue bastante fácil, conseguir los resultados fue algo complicado ya que es un proceso que varía según el tipo de datos, como se mencionó anteriormente trabajamos con un csv. "bank-full" el cual contiene información respecto a una base de datos de clientes. El proceso inició bastante bien, la base de datos pasó por un proceso de limpieza de datos con el uso de excel para quedarnos con las columnas que se iban a utilizar en el ejercicio (Age,job,marital,education,balance,day). Se utilizaron funciones como "Assemble" y "Features" para crear los componentes del MLPC, el cual esta constituido por arreglos y capas. Dividimos data con random split y definimos las capas de la red neuronal. Una vez que el set up está ensamblado MLPC, se añaden etiquetas, se procede a hacer model fitting y hacer las predicciones, se evaluá el modelo con la métrica accuracy, para finalizar se imprimen resultados.
Si bien cada proceso de modelado de información es distinto, en la elaboración de este ejercicio nos resultó compleja la parte de labels y sobre cuestiones técnicas definitivamente es necesario contar con una máquina con buena memoria ram.


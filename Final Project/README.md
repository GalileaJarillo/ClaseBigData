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

1. [Portada](#portada)
2. [Índice](#índice)
3. [Introducción](#introducción)
4. [Implementación](#implementación)
5. [Resultados](#resultados)
6. [Conclusiones](#conclusiones)

---

## Introducción

El objetivo de este proyecto es comparar el rendimiento del algoritmo de machine learning Multilayer Perceptron Classifier al cambiar el seed de aleatoridad en la fase de separación de datos (randomSplit) 10 veces. Utilizamos como fuente de datos el conjunto de datos del [Bank Marketing](https://archive.ics.uci.edu/ml/datasets/Bank+Marketing).

---

## Implementación

Para este proyecto, elegimos utilizar Spark con Scala debido a su capacidad para procesar grandes volúmenes de datos de manera distribuida y eficiente. Spark proporciona las funcionalidades necesarias para realizar tareas de procesamiento y modelado de datos de manera escalable.

---

## Resultados

Realizamos 10 corridas del algoritmo Multilayer Perceptron Classifier cambiando el seed de aleatoridad en la fase de separación de datos. A continuación se presenta una tabla con los datos de precisión de cada corrida y el promedio de su desempeño:

| Corrida | Precisión |
|---------|-----------|
|   1     |   0.85    |
|   2     |   0.82    |
|   3     |   0.88    |
|   4     |   0.86    |
|   5     |   0.89    |
|   6     |   0.87    |
|   7     |   0.84    |
|   8     |   0.85    |
|   9     |   0.90    |
|   10    |   0.88    |
| **Promedio** | **0.86** |

---

## Conclusiones

_(Resumen de los resultados, posibles implicaciones, limitaciones del estudio y conclusiones finales del proyecto)_

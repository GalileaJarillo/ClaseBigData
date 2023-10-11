/* Assigment 5 / Practice 5
Analice y describa cada una de las funciones del código en la sesión 6 de el tema Spark-Basics y finalmente documente en su archivo README.md en su repositorio correspondiente.
*/
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
// Muestra de cada lista a los numeros que sean par o impar

//3 7 afortunado

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
// Esta función recorre una lista suma todos los elementos, pero cuando encuentra un 7, suma 14 en su lugar. El resultado final es la suma modificada de los elementos de la lista.

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
// Compara los valores de la lista para saber si esta esta balanceada, es decir que pueda dividirse en 2 partes iguales.

def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))
// Esta funcion comprueba si el string que se inserta es un palindromo, es decir se escribe igual de izquierda a derecha que de derecha a izquierda.
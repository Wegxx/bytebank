package br.com.alura.array

fun main (){
    val serie: IntRange = 1.rangeTo(10)
    for (s in serie) {
        print("$s ")
    }
    println("")
    println("------------")

    val numerosPares = 2.until(100) step 2
    for (numeroPar in numerosPares){
        print("$numeroPar ")
    }
    println("")
    println("------------")

    val numerosParesReversos = 100 downTo (0) step 2
    numerosParesReversos.forEach { print("$it ") }
    println("")
    println("------------")

    val intervalo = 1500.0..5000.0
    val salario = 5001.0

    if(salario in intervalo){
        println("Está dentro do intervalo")
    } else { println ("Não está dentro do intervalo")}
    println("")
    println("------------")

    val alfabeto = "a".."z"
    val letra = "k" /*perceba que letras maiusculas não estao inceridas no range*/
    println(letra in alfabeto)


}
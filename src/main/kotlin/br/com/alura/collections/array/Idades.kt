package br.com.alura.array

fun main (){
    val idades : IntArray = intArrayOf(10, 12,18, 33, 40, 67)
    val maiorIdade = idades.maxOrNull()
    println("Maior idade: $maiorIdade")

    val menorIdade = idades.minOrNull()
    println("Menor idade: $menorIdade")

    val media: Double = idades.average()
    println("Media: $media")

    val todosMaiores = idades.all { it > 18 } /*se todos os elementos sarisfazerem a sentença retorna true*/
    println("Todos maiores? $todosMaiores")

    val existeMaior = idades.any { it > 18 } /*pelo menos um satisfaz a sentença*/
    println("Algum aluno é maior de idade? $existeMaior")

    val maiores = idades.filter { it >= 18 } /* filtra somente para os elementos que satisfazem a função*/
    println("Maiores $maiores")

    val busca = idades.find { it >= 18 }  /*busca pelo primeiro elemento que satisfaz*/
    println("Busca: $busca")

}
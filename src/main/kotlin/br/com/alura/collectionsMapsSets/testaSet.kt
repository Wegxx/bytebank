package br.com.alura.collectionsMapsSets

fun testaSet() {
    val assistiramCursoAndroid: Set<String> = mutableSetOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin: Set<String> = mutableSetOf("Alex", "Paulo", "Maria")
    //val assistiramAmbos: Set<String> = assistiramCursoAndroid + assistiramCursoKotlin //A ordem importa
    val assistiramAmbos = mutableSetOf<String>()
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    assistiramAmbos.add("Gui") // Gui não foi add pois já existe o SET considera apenas elemntos diferentes
    assistiramAmbos.add("Ana")

    println(assistiramAmbos)
    println(assistiramCursoKotlin + assistiramCursoAndroid)
    println(assistiramCursoKotlin union assistiramCursoAndroid)

    println(assistiramCursoAndroid - assistiramCursoKotlin)
    println(assistiramCursoAndroid subtract assistiramCursoKotlin)

    println(assistiramCursoKotlin intersect assistiramCursoAndroid)

    val assistiramList = assistiramAmbos.toMutableList()
    assistiramList.add("Alex")
    println(assistiramList)
    println(assistiramList.toSet())//Ao converter o comportamento do set já é aplicado
}

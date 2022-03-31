package br.com.alura.array.list

fun List<Livro?>.imprimeComMarcadores(){
    val textoFormatado = this
        .filterNotNull()
        .joinToString(separator = "\n") {
        "- ${it.titulo} de ${it.autor}"
    }
    println("### lISTA DE lIVROS ### \n$textoFormatado")
}
package br.com.alura.array.list

fun main(){
    listaDeLivros.groupBy { it.editora ?: "Editoria desconhecida" }.forEach{(editora: String?, livros: List<Livro>) ->
        println("$editora: ${livros.joinToString { it.titulo }}")
    }
}
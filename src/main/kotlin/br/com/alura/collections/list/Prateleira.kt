package br.com.alura.array.list

 data class Prateleira(val genero: String, val livros: List<Livro>){

    fun organizarPorAutor(): List<Livro>{
        return livros.sortedBy { it.autor } // O metodo sortedBy CRIA uma nova lista e não altera a anterior
    }

    fun organizarPorAnoPublicacao(): List<Livro>{
        return livros.sortedBy { it.anoPublicacao }
    }
}
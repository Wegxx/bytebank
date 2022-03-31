package br.com.alura.collectionsMapsSets

fun testaCopia() {
    val banco = BancoDeNomes()
    val nomesSalvos: Collection<String> = banco.nomes
    // banco.nomes.add("Alex")
    banco.salva("Alex")
    println(nomesSalvos) // "nomesSalvos" é apenas uma copia imutavel do get e não aponta para o objeto em si
    println(BancoDeNomes().nomes)
    println(banco.nomes)
}

class BancoDeNomes{

    val nomes: Collection<String>get() = Companion.dados.toList() // o to list é necessario para criar
    // uma copia dos dados que sejam imutaveis para usuários externos impedindo, inclusive seu casting
    //DICA Declarar a variavel get como List teria o mesmo resultado

    fun salva(nome:String){
        Companion.dados.add(nome)
    }

    companion object {
        private val dados = mutableListOf<String>()
    }
}
fun testaColecao() {
    val nomes: Collection<String> = mutableListOf("Alex", "Fran", "Gui", "Maria", "Ana")

    for (nome: String in nomes) {
        println(nome)
    }
    println(nomes)
    println("Tem o nome Alex? ${nomes.contains("Alex")}")
    println("Tamanho da coleção ${nomes.size}")
}
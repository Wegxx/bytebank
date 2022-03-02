import br.com.alura.bytebank.modelo.Endereco
import java.lang.IllegalStateException

fun main() {
    println("início main")

    var enderecoNulo: Endereco? = Endereco(logradouro = "rua vergueiro", complemento = "predio")
    val logradouroNovo: String? = enderecoNulo?.logradouro
    enderecoNulo?.let {
        println(it.logradouro.length)
        val tamanhoComplemento: Int = it.complemento?.length ?: throw IllegalStateException("Complemento não pode ser vazio")
        println(tamanhoComplemento)
    }

    teste("")
    teste(1)

    println("fim main")
    }

fun teste(valor: Any){
    val numero: Int? = valor as? Int
    println(numero)
}










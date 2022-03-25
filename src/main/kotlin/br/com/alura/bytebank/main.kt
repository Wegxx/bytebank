import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.modelo.SistemaInterno
import java.util.*

fun main() {

    //val endereco =  Endereco(logradouro = "rua vergueiro", numero = 3185)
    //val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".uppercase(Locale.getDefault())
    //println(enderecoEmMaiusculo)

   Endereco(logradouro = "rua vergueiro", numero = 3185).let { endereco ->
        "${endereco.logradouro}, ${endereco.numero}".uppercase(Locale.getDefault())
   }.let (::println)

    val enderecosComComplemento = listOf(Endereco(complemento = "casa"),
        Endereco(complemento = "apartamento"),
        Endereco()).filter (predicate = { endereco -> endereco.complemento.isNotEmpty() }).let (block = (::println))

    soma (1, 5, resultado = (:: println))

    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autenticacao(senha: Int) = this.senha == senha

    }

    SistemaInterno().entrar(autenticavel, 1234, autenticado = {
        println("Realiza pagamento")
    })

}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit){
    println("antes da soma")
    resultado(a + b)
    println("depois da soma")
}

















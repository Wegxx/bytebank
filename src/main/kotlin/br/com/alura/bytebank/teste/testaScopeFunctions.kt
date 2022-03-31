package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco
import java.util.*

fun testaScopeFuctions() {
    //val endereco =  Endereco(logradouro = "rua vergueiro", numero = 3185)
    //val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".uppercase(Locale.getDefault())
    //println(enderecoEmMaiusculo)

    run { println("execução do run sem extenção") }

    val endereco = Endereco().also { println("Criando endereço") }.apply {
        logradouro = "rua vergueiro"
        numero = 3185
    }

    with(endereco) {
        "$logradouro, $numero".uppercase(Locale.getDefault())
    }.let { enderecoEmMaiusculo: String ->
        println(enderecoEmMaiusculo)
    } // apply, run, with -> this / let, also -> it

    val enderecosComComplemento = listOf(
        Endereco(complemento = "casa"),
        Endereco(complemento = "apartamento"),
        Endereco()
    ).filter(predicate = { endereco -> endereco.complemento.isNotEmpty() }).let(block = (::println))
}
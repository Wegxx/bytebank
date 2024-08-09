package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

fun testaAny() {
    println("Bem Vindo ao Bytebank")
    println()
    val endereco = Endereco (
        logradouro = "Rua Vergueiro",
        complemento = "Alura",
        cep = "00000-000")

    val enderecoNovo = Endereco (
        logradouro = "Vila Maria",
        numero = 1000,
        cep = "00000-000")


    println(endereco.equals(enderecoNovo))

    println(endereco.hashCode())
    println(enderecoNovo.hashCode())

    println(endereco)
    println(enderecoNovo)

}
package br.com.alura.bytebank.teste

import br.com.alura.bytebank.novomodelo.Cliente as NovoCliente
import br.com.alura.bytebank.modelo.Cliente

fun testaClassesDeMesmoNome(){

    val cliente = Cliente (nome = "Alex", cpf = "", senha = 1)
    val clienteNovo = NovoCliente(nome = "Alexandra", cpf = "", senha = 1)
}


package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaHOF() {
    soma(1, 5, resultado = {valor -> //Soma por high order function
        println(valor)}
    )
    somaReceiver(1, 5, resultado = { //Soma por Receiver
        println(this)
    })

    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autenticacao(senha: Int) = this.senha == senha

    }

    val sistema = SistemaInterno()
    sistema.entrar(autenticavel, 1234, autenticado = {
        println("realizar pagamento")
    })
    sistema.entrarReceiver(autenticavel, 1234, autenticado = {
        pagamento()
    })

    SistemaInterno().entrar(autenticavel, 1234, autenticado = {
        println("Realiza pagamento")
    })
}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit){
    println("antes da soma")
    resultado(a + b)
    println("depois da soma")
}

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit){
    print("antes da soma")
    val total = a + b
    total.resultado()
    println("depois da soma ")
}
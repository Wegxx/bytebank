import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco
import kotlin.math.absoluteValue

fun main() {

}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("taxa mensal: $taxaMensal")

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Alex", cpf = "111.111.111-11", senha = 1234), 1000)
    contaPoupanca.run {
        depositar(1000.0)
        saldo * taxaMensal
    }.let { rendimentoMensal ->
        println(rendimentoMensal)
    }

    val redimentoAnual = run {
        var saldo: Double = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }
    println("simulação rendiemnto anual $redimentoAnual")
}

fun testaWith() {
    val enderecoCompleto = with(Endereco()) {
        logradouro = "rua vergueiro"
        numero = 3185
        bairro = "Vila Marina"
        cidade = "São Paulo"
        estado = "SP"
        cep = "02310-063"
        complemento = "Apartemento"
        completo()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}























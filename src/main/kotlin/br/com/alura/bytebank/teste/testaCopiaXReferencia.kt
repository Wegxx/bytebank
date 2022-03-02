import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca

fun testaCopiaXReferencia () {
    val numeroX = 10
    var numeroY = numeroX
    numeroY ++

    println("numeroX $numeroX")
    println("numeroY $numeroY") // Repare que a variavel X não se altera pois a Y é uma copia independente dela

    val joao = Cliente (nome = "Joao", cpf = "", senha = 1)
    val contaJoao = ContaCorrente(titular = joao, 1002)

    val maria = Cliente (nome = "Maria", cpf = "", senha = 2)
    var contaMaria = ContaPoupanca(titular = maria, 1003)


    println("br.com.alura.bytebank.modelo.Conta Joao: ${contaJoao.titular}")
    println("br.com.alura.bytebank.modelo.Conta Maria ${contaMaria.titular}") // Repare nesse caso que os dois se alteram pois fazem referencia ao mesmo espaço alocado de memoria

    println(contaJoao)
    println(contaMaria)
}
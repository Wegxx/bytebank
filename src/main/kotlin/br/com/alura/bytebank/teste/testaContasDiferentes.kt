import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco

fun testaContasDiferentes(){

    val alex = Cliente (
        nome = "Alex",
        cpf = "111.111.111-11",
        senha = 1,
        endereco = Endereco(logradouro = "Rua Vergueiro")
    )

    val contaCorrenteAlex = ContaCorrente(
        titular = alex,
        numero = 1000
    )

    println("titular ${contaCorrenteAlex.titular}")
    println("nome do titular ${contaCorrenteAlex.titular.nome}")
    println("cpf do titular ${contaCorrenteAlex.titular.cpf}")
    println("endereco do titular ${contaCorrenteAlex.titular.endereco.logradouro}")

    val fran = Cliente (nome = "Fran", cpf = "", senha = 2)
    val contaPoupancaFran = ContaPoupanca(
        titular = fran,
        numero = 1000
    )

    contaCorrenteAlex.depositar(1000.0)
    contaPoupancaFran.depositar(1000.0)

    println("Saldo corrente Alex: ${contaCorrenteAlex.saldo}")
    println("Saldo poupanca Fran: ${contaPoupancaFran.saldo}")

    contaCorrenteAlex.sacar(100.0)
    contaPoupancaFran.sacar(100.0)

    println("Saldo apos saque corrente Alex: ${contaCorrenteAlex.saldo}")
    println("Saldo apos saque poupanca Fran: ${contaPoupancaFran.saldo}")

    contaCorrenteAlex.transferir(contaPoupancaFran, 100.0, 1)

    println("Saldo apos saque e transferenca corrente Alex: ${contaCorrenteAlex.saldo}")
    println("Saldo apos saque e transferencia poupanca Fran: ${contaPoupancaFran.saldo}")

    contaPoupancaFran.transferir(contaCorrenteAlex, 100.0, 2)

    println("Saldo apos saque e 2transferenca corrente Alex: ${contaCorrenteAlex.saldo}")
    println("Saldo apos saque e 2transferencia poupanca Fran: ${contaPoupancaFran.saldo}")
}
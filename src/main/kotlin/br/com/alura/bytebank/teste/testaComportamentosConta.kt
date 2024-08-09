import br.com.alura.bytebank.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException
import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.ContaSalario

fun testaComportamentoConta() {

    val alex = Cliente (nome = "Alex", cpf = "", senha = 1)
    val contaAlex = ContaCorrente( titular = alex, 1000)
    contaAlex.depositar(200.0)

    val fran = Cliente (nome = "Fran", cpf = "", senha = 2)
    val contaFran = ContaPoupanca(titular = fran, 1001)
    contaFran.depositar(300.0)

    val maria = Cliente (nome = "Maria", cpf = "", senha = 3)
    val contaMaria = ContaSalario(titular = maria, 1002)
    contaMaria.depositar(400.0)


    println()
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println()
    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println()
    println("Depositando na conta do Alex")
    contaAlex.depositar(50.0)
    println(contaAlex.saldo)

    println()
    println("Depositando na conta da Fran")
    contaFran.depositar(70.0)
    println(contaFran.saldo)

    println()
    println("Sacando na conta do Alex")
    contaAlex.sacar(250.0)
    println(contaAlex.saldo)

    println()
    println("Sacando na conta da Fran")
    contaFran.sacar(100.0)
    println(contaFran.saldo)

    println()
    println("Sacando em excesso na conta do Alex")
    contaAlex.sacar(250.0)
    println(contaAlex.saldo)

    println()
    println("Sacando em excesso na conta da Fran")
    contaFran.sacar(500.0)
    println(contaFran.saldo)

    println()
    println("Transferencia da conta da Fran p/ Alex")
    try { contaFran.transferir(contaAlex, 50.0, 1)
    } catch (e: SaldoInsuficienteException){
        println("Falha na transferencia")
        println("Saldo Insuficiente")
        e.printStackTrace()
    } catch (e: FalhaAutenticacaoException){
        println("Falha na transferencia")
        println("Falha na autenticação")
        e.printStackTrace()
    } catch (e:Exception){
        println("Erro desconhecido")
        e.printStackTrace()
    }
    println(" Saldo Fran: ${contaFran.saldo}")
    println(" Saldo Alex: ${contaAlex.saldo}")

}
package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException

abstract class Conta(
    val titular: Cliente,
    val numero: Int):Autenticavel {

    var saldo = 0.0
        protected set

    companion object Contador {
        var total = 0
         private set
    }

    init {
        total++
    }

    override fun autenticacao(senha: Int): Boolean {
        return titular.autenticacao(senha)
    }

  fun depositar (valor: Double){
        if (valor >= 0) {
            this.saldo += valor
        } else { println("Não é possivel depoisitar um valor menor que 0") }
    }

    open fun sacar (valor: Double) {
       val valorComTaxa = valor + 0.1
       if (this.saldo >= valorComTaxa){
           this.saldo -= valorComTaxa
       } else { println("Não é possivel sacar. A conta não possui saldo suficiente") }
   }

}

abstract class ContaEspecial(titular: Cliente, numero: Int)
    : Conta(titular = titular, numero = numero) {

    fun transferir (destino: Conta, valor: Double, senha: Int) {

        if(saldo<valor){
            throw  SaldoInsuficienteException(
                mensagem = "O saldo é insuficiente, saldo: $saldo, valor a ser subtraido $valor"
            )
        }

        if (!autenticacao(senha)){
            throw FalhaAutenticacaoException()
        }
        throw RuntimeException()
            saldo -= valor
            destino.depositar(valor)
        }
    }


class ContaPoupanca(
    titular: Cliente,
    numero: Int) : ContaEspecial(titular = titular, numero = numero){

}

class ContaCorrente(
    titular: Cliente,
    numero: Int) : ContaEspecial(titular = titular, numero = numero)
{
    override fun sacar(valor: Double) {
        val valorComTaxa = valor + 0.1
        if (this.saldo >= valorComTaxa){
            this.saldo -= valorComTaxa
        } else { println("Não é possivel sacar. A conta não possui saldo suficiente") }
    }
}

class ContaSalario (
    titular: Cliente,
    numero: Int) : Conta(titular = titular, numero = numero) {

}
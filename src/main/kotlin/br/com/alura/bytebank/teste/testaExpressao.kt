package br.com.alura.bytebank.teste

import java.lang.NumberFormatException

fun testaExpressaao (){
    val entrada: String = "1,9"

    val valorRecebido: Double? =  try{
        entrada.toDouble()
    }catch (e: NumberFormatException){
        println("Problema na conversão")
        e.printStackTrace()
        null
    }
    val valorComTaxa: Double? = if(valorRecebido != null){
        valorRecebido + 0.1
    }else {null}

    if (valorComTaxa!= null){
        println("valor recebido: $valorComTaxa")
    }else { println("valor inválido") }
}
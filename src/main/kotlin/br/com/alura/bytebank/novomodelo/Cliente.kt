package br.com.alura.bytebank.novomodelo

import br.com.alura.bytebank.modelo.Autenticavel

class Cliente (
    val nome: String,
    val cpf: String,
    protected val senha: Int): Autenticavel {


    override fun autenticacao(senha: Int): Boolean {
        if (this.senha == senha){
            return true
        }
        return false
    }
}


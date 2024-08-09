package br.com.alura.bytebank.modelo

class Cliente (
    val nome: String,
    val cpf: String,
    var endereco: Endereco = Endereco(),
    protected val senha: Int): Autenticavel {


    override fun autenticacao(senha: Int): Boolean {
        if (this.senha == senha){
            return true
        }
        return false
    }
}


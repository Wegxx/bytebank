package br.com.alura.bytebank.modelo

class SistemaInterno {

    fun entrar(admin: Autenticavel, senha: Int, autenticado: () -> Unit = {}){
        if(admin.autenticacao(senha)){
            println("Bem Vindo ao ByteBank")
            autenticado()
        } else {println("Falha na Autenticação")}
    }

}

package br.com.alura.bytebank.modelo

class SistemaInterno {

    fun entrar(admin: Autenticavel, senha: Int){
        if(admin.autenticacao(senha)){
            println("Bem Vindo ao ByteBank")
        } else {println("Falha na Autenticação")}
    }

}

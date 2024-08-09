package br.com.alura.bytebank.modelo

class SistemaInterno {

    fun entrar(admin: Autenticavel, senha: Int, autenticado: () -> Unit = {}){
        if(admin.autenticacao(senha)){
            println("Bem Vindo ao ByteBank")
            autenticado()
        } else {println("Falha na Autenticação")}
    }

    fun entrarReceiver(admin: Autenticavel, senha: Int, autenticado: SistemaInterno.() -> Unit = {}){
        if(admin.autenticacao(senha)){
            println("Bem Vindo ao ByteBank")
            autenticado(this)
        } else {println("Falha na Autenticação")}
    }

    fun pagamento(){
        println("realziando pagamento")
    }

}

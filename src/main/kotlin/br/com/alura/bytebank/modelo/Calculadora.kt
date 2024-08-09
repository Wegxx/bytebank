package br.com.alura.bytebank.modelo

class Calculadora {

    var total: Double = 0.0
        private set

    fun registra(funcionario: Funcionario){  //Perceba que a aplicação funciona somente com essa função.
        println("nome ${funcionario.nome}")
        this.total += funcionario.getBonificacao() // Isso é possivel pois todas classes filho são consideradas como um funcionario
    }

}


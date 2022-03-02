import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.Diretor
import br.com.alura.bytebank.modelo.Gerente
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaAutenticacao (){

    val gerente = Gerente(
        nome = "Alex",
        cpf = "111.111.111-11",
        salario = 1000.0,
        senha = 1000
    )

    val diretora = Diretor(
        nome = "Fran",
        cpf = "222.222.222-22",
        salario = 2000.0,
        senha = 2000,
        plr = 200.0
    )

    val cliente = Cliente(
        nome = "Gui",
        cpf = "333.333.333-33",
        senha = 1234
    )


    val sistema = SistemaInterno()

    sistema.entrar(gerente, 2000) //Deve retornar falha pois a senha esta incorreta
    sistema.entrar(diretora, 1000) //Deve retornar falha pois a senha esta incorreta
    sistema.entrar(cliente, 1234) // Correto



}
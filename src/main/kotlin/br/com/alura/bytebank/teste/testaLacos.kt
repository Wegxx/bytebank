fun testaLacos (){
    var i = 0

    while (i <= 5) {

        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("Titular = $titular")
        println("Número da conta = $numeroConta")
        println("Saldo = $saldo")
        println()

        // testaCondicoes(saldo)
        i ++
    }
}
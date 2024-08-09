package br.com.alura.collectionsMapsSets

fun testaComportamentosMap() {
    //Criando Map
    val pedidos: MutableMap<Int, Double?> = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 50.0,
        4 to null
    )// o infix "to" gera perda de perfomance em relação ao pair
    val valorPedido = pedidos.get(4)//Devolve o nulo
    val valorPedido2 = pedidos.get(5)//Também devolve o nulo, isso gera uma incerteza sobre a existencia do argumento
    //val valorPedido3 = pedidos.getValue(5)//Retorna uma exeption com referencia caso o argumento não exista
    println(valorPedido)
    println(valorPedido2)
    //println(valorPedido3)

    val mensagem = pedidos.getOrElse(0, { "Não tem o pedido" })//Caso não existe a key o lambida ({}) é retornado
    println(mensagem)
    println(pedidos.getOrDefault(0, -1.0))//Pega o defaultValue caso o a key não exista

    println(pedidos.keys)
    for (numero in pedidos.keys) {
        println("Pedido $numero")
    }

    println(pedidos.values)
    for (valor in pedidos.values) {
        println("Valor do pedido: $valor")
    }

    val pedidos2: MutableMap<Int, Double> = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 64.0),
        3 to 50.0,
        4 to 100.0,
        5 to 100.0,
        6 to 80.0
    )

    //Filter
    val pedidosFiltrados = pedidos2.filter { (numero, valor) ->
        numero % 2 == 0 && valor > 50.0 // o % é resto ou diferença
    }//O filter do map requer um pair de parametro
    println(pedidosFiltrados)


    val pedidosAcima = pedidos2.filterValues { valor ->
        valor > 70.0
    }
    val pedidosPares = pedidos2.filterKeys { numero ->
        numero % 2 == 0
    }
    println(pedidosAcima)
    println(pedidosPares)

    //Plus + (cria outra lista)
    println(pedidos2 + Pair(7, 90.0))//Cria um novo map sem alterar o original
    println(pedidos2 + mapOf(7 to 90.0, 8 to 20.0))//Cria um novo map sem alterar o original
    println(pedidos2)

    //Minus - (cria outra lista)
    println(pedidos2 - listOf(6, 5)) // O - não
    println(pedidos2)

    //Add (remove do original)
    //pedidos2.putAll(listOf<Pair<Int, Double>>(7 to 90.0, 8 to 20.0))
    pedidos2 += (listOf<Pair<Int, Double>>(7 to 90.0, 8 to 20.0))
    println(pedidos2)

    // Remove (remove do original)
    pedidos2.keys.remove(1)
    println(pedidos2)

    pedidos2.values.remove(50.0)
    println(pedidos2)

    pedidos2.values.remove(100.0)// o 4 sera removido pois o values.remove remosem sempre o primeiro match de valor encontrado
    println(pedidos2)

    pedidos2 -= 6
    pedidos2
}

fun testaMap(pedidos:MutableMap<Int,Double?>) {

    println(pedidos)

    val pedido = pedidos[0]//O 0 é a chave do pedido que não existe portanto nada sera retornado
    val pedido2 = pedidos[1]//O 1 é a chave do pedido 20
    pedido?.let {
        println("pedido $it")
    }
    pedido2?.let {
        println("pedido $it")
    }
    for (p: Map.Entry<Int, Double?> in pedidos) { // p = pedido in pedidos
        println("numero do pedido ${p.key}")
        println("valor do pedido ${p.value}")
    }
    //Add no map
    pedidos[4] = 70.0
    println(pedidos)
    pedidos.put(5, 80.0)
    println(pedidos)

    //Atualizado map
    pedidos[1] = 100.0
    println(pedidos)
    pedidos.putIfAbsent(6, 200.0)//Somente add em pedido n existente
    pedidos.putIfAbsent(6, 300.0)//Não add pois nao subsescreve
    println(pedidos)

    //Remover Pedidos
    pedidos.remove(6)
    println(pedidos)
    pedidos.remove(3, 100.0)//Somente remove se o valor for igual ao especificado
    println(pedidos)
}
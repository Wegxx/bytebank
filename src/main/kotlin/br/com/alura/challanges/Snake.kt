package br.com.alura.challanges

fun findSnakePath(snakeArray: Array<String>): List<Pair<Int, Int>>? {
    val avaliablePositions = getFilledCharacters(snakeArray)
    println(avaliablePositions)
    val head = avaliablePositions.find { it.first == "h"} ?: return null
    println("head = $head")
    val finalSnakeList = mutableListOf<Pair<Int, Int>>()
    var actualPosition = head
    do {
        avaliablePositions.removeIf { it.second == actualPosition.second }
        val nextPosition = findNextBodyPart(actualPosition, avaliablePositions)
        finalSnakeList.add(actualPosition.second)
        actualPosition = nextPosition ?: head
    }while (nextPosition != null)


    return finalSnakeList
}

fun findNextBodyPart(position : Pair<String, Pair<Int, Int>>,
                     filledPositions: List<Pair<String, Pair<Int, Int>>>): Pair<String, Pair<Int, Int>>? {
    val directions = mapOf(
            ">" to Pair(0, 1),  // aponta para a direita
            "<" to Pair(0, -1), // aponta para a esquerda
            "^" to Pair(-1, 0), // aponta para a cima
            "v" to Pair(1, 0), //// aponta para a baixo
        )

    val right = Pair(position.second.first, position.second.second + 1)
    val left = Pair(position.second.first, position.second.second - 1)
    val up = Pair(position.second.first + 1, position.second.second)
    val bottom = Pair(position.second.first - 1, position.second.second)
    val possibleNextMoves = filledPositions.filter {
        it.second ==  right ||
                it.second == left ||
                it.second == up  ||
                it.second == bottom
    }
    println("possible first body parts = $possibleNextMoves")
    return possibleNextMoves.find { bodyPart ->
        val direction = directions[bodyPart.first]
        val pointsTo = Pair(bodyPart.second.first + direction?.first!!, bodyPart.second.second + direction.second)
        position.second == pointsTo
    }
}

fun getFilledCharacters(snakeArray: Array<String>): MutableList<Pair<String, Pair<Int, Int>>> {
    val filledCells = mutableListOf<Pair<String, Pair<Int, Int>>>()

    for (rowIndex in snakeArray.indices) {
        for (colIndex in snakeArray[rowIndex].indices) {
            val char = snakeArray[rowIndex][colIndex]
            if (char != ' ') {  // Se a célula não estiver vazia
                filledCells.add(Pair(char.toString(), Pair(rowIndex, colIndex)))
            }
        }
    }
    return filledCells
}

fun snake() {
    val snakeArray = arrayOf(
        ">>>>h",
        "^v< v",
        "^<^<<"
    )
    val snakePath = findSnakePath(snakeArray)
    println("Snake path from head to tail: $snakePath")
}
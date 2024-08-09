package br.com.alura.challanges

data class Path(val matrix: Array<IntArray>, val pathPositions: MutableList<Pair<Int, Int>>)

fun ratInAMaze(maze: Array<IntArray>, start: Pair<Int, Int>, end: Pair<Int, Int>) {
    val path = Array(maze.size) { IntArray(maze[0].size) }
    // Inicia o caminho a partir da posição (1, 0) e finaliza na posição (5, 6)
    val pathsResultList: MutableList<Path> = mutableListOf()
    solveMaze(maze, start.first, start.second, path, end.first, end.second, pathsResultList)
    val bestPaths = pathsResultList.sortedBy { it.pathPositions.size }.take(3)
    println()
    println("TOP 3 caminhos")
    bestPaths.forEachIndexed { i, resultPath ->
        println()
        println("Caminho ${i+1} -> tamanho: ${resultPath.pathPositions.size}")
        printMatrix(resultPath.matrix)
        println("${resultPath.pathPositions}")
    }
}

private fun solveMaze(maze: Array<IntArray>, i: Int, j: Int, path: Array<IntArray>, endRow: Int, endCol: Int, resultList: MutableList<Path>) {
    val rows = maze.size
    val cols = maze[0].size

    // Verifica se i, j são índices válidos
    if (i < 0 || j < 0 || i >= rows || j >= cols) return

    // Se a célula já faz parte do caminho
    if (path[i][j] == 1) return

    // Se a célula está bloqueada no labirinto (valor da célula = 0)
    if (maze[i][j] == 0) return

    // Se todas as condições anteriores falharem, então a célula é um caminho possível
    // Inclua a célula no caminho atual
    path[i][j] = 1

    // Se chegamos ao ponto final
    if (i == endRow && j == endCol) {
        savePath(path, resultList)
        printMatrix(path)
        printPathPositions(path)
        path[i][j] = 0
        return
    }

    // Chama recursivamente para encontrar todos os caminhos
    solveMaze(maze, i - 1, j, path, endRow, endCol, resultList) // cima
    solveMaze(maze, i, j + 1, path, endRow, endCol, resultList) // direita
    solveMaze(maze, i + 1, j, path, endRow, endCol, resultList) // baixo
    solveMaze(maze, i, j - 1, path, endRow, endCol, resultList) // esquerda

    // Remove a célula do caminho atual, se necessário
    path[i][j] = 0
}

private fun savePath(path: Array<IntArray>, resultList: MutableList<Path>) {
    // Cria uma cópia da matriz path
    val pathCopy = Array(path.size) { path[it].clone() }
    val positions = mutableListOf<Pair<Int, Int>>()
    for (i in path.indices) {
        for (j in path[i].indices) {
            if (path[i][j] == 1) {
                positions.add(Pair(i, j))
            }
        }
    }
    resultList.add(Path(pathCopy, positions))
}

fun invertMatrix(grid: Array<IntArray>) {
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            grid[i][j] = if (grid[i][j] == 0) 1 else 0
        }
    }
    println("Matriz invertida:")
    printMatrix(grid)
}

fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        for (value in row) {
            print("$value ")
        }
        println()
    }
}

fun printPathPositions(path: Array<IntArray>) {
    val positions = mutableListOf<Pair<Int, Int>>()
    for (i in path.indices) {
        for (j in path[i].indices) {
            if (path[i][j] == 1) {
                positions.add(Pair(i, j))
            }
        }
    }
    println("Posições percorridas: $positions")
}

// Exemplo de uso
fun ratInAMazeChallange() {
    // Exemplo de grade com obstáculos
    val grid = arrayOf(
        intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1),
        intArrayOf(0,0,0,0,0,1,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1),
        intArrayOf(1,0,1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1),
        intArrayOf(1,0,1,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1),
        intArrayOf(1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1),
        intArrayOf(1,0,1,1,1,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1),
        intArrayOf(1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1),
        intArrayOf(1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1),
        intArrayOf(1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,1,0,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,1,0,1,1,0,1,0,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,1,0,1,1,0,1,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,0,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,0,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,0,0,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,0,0,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1),
        intArrayOf(1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1),
        intArrayOf(1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1),
        intArrayOf(1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1),
        intArrayOf(1,0,1,0,1,1,1,0,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1),
        intArrayOf(1,0,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1),
        intArrayOf(1,0,1,0,1,1,1,1,0,1,0,0,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,1),
        intArrayOf(1,0,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,1),
        intArrayOf(1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0),
        intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    )
    invertMatrix(grid)

    // Calcula e imprime o caminho a partir da nova posição inicial
    ratInAMaze(grid, Pair(1, 0), Pair(40, 41))
}
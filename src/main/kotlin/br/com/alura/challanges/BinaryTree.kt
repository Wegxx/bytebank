package br.com.alura.challanges

data class Node (
    var value: Int,
    var left: Node? = null,
    var right: Node? = null
)

fun createBinaryTree (array: Array<Int>) {
    val baseNode = Node(array.first())
    val newArray = array.filter {it != baseNode.value}
    println("Base Node: $baseNode, and numbers to be added: $newArray")
    newArray.forEach{
        buildBinaryTree(baseNode, it)
    }
    println("BinaryTree: $baseNode")
}

fun buildBinaryTree (tree: Node, addingValue: Int){
    if (addingValue > tree.value) {
        val rightValue = tree.right
        if(rightValue == null){
            tree.right = Node(addingValue)
        } else {
            buildBinaryTree(rightValue, addingValue)
        }

    } else {
        val leftValue = tree.left
        if(leftValue == null){
            tree.left = Node(addingValue)
        } else {
            buildBinaryTree(leftValue, addingValue)
        }
    }

}

fun binaryTree() {
    // Array de numeros para criar a arvore binária
    val array = arrayOf(22, 21, 34, 64, 7, 6, 11, 18, 89, 76)
    createBinaryTree(array)
}
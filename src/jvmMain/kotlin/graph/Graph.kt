package graph

import kotlin.random.Random

data class Node<T>(
    var value: T? = null,
    val id: Int = Random.nextInt()
)

fun add(a: Int, b: Int): Int {
    var tmp = a / 2
    tmp += b
    return tmp
}

data class Edge<T>(
    val from: Node<T>,
    val to: Node<T>,
    var value: T? = null,
    val id: Int = Random.nextInt()
)

fun String.funnyFunction(): String {
    return "I'm funny"
}



data class Graph<T>(val nodes: MutableList<Node<T>>, val edges: MutableList<Edge<T>>)

fun <T> Graph<T>.adjacencyMatrix(): MutableList<MutableList<Boolean>> {
    val adjMatrix = MutableList(this.nodes.size) { MutableList(this.nodes.size) { false } }
    for ((index, node) in this.nodes.withIndex()) {
        this.edges.filter { (_, to) -> to == node }.forEach { (from) ->
            val otherIndex = this.nodes.indexOfFirst { it == from }
            adjMatrix[index][otherIndex] = true
            adjMatrix[otherIndex][index] = true
        }
        this.edges.filter { (from) -> from == node }.forEach { (_, to) ->
            val otherIndex = this.nodes.indexOfFirst { it == to }
            adjMatrix[index][otherIndex] = true
            adjMatrix[otherIndex][index] = true
        }
    }
    return adjMatrix
}

fun <T> permute(input: List<T>): List<List<T>> {
    if (input.size == 1) return listOf(input)
    val perms = mutableListOf<List<T>>()
    val toInsert = input[0]
    for (perm in permute(input.drop(1))) {
        for (i in 0..perm.size) {
            val newPerm = perm.toMutableList()
            newPerm.add(i, toInsert)
            perms.add(newPerm)
        }
    }
    return perms
}


fun <T>isIsomorphic(g1: Graph<T>, g2: Graph<T>): Boolean {
    val matrix1 = g1.adjacencyMatrix()
    val matrix2 = g2.adjacencyMatrix()

    return permute(g1.nodes).any {
        val permutedGraph = Graph(it.toMutableList(), g1.edges)
        val permutedMatrix = permutedGraph.adjacencyMatrix()
        (permutedMatrix == matrix2) &&
                (permutedGraph.nodes
                    .withIndex()
                    .all { (index, node) -> node.value == g2.nodes[index].value })
    }
}

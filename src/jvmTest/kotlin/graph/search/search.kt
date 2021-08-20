package graph.search

import graph.*

private fun <T>depthSearch(
    g: Graph<T>,
    adjMatrix: List<List<Boolean>>,
    index: Int,
    searching: T,
    visited: MutableList<Int>
): Node<T>? {
    if (g.nodes[index].value == searching) {
        return g.nodes[index]
    }
    visited.add(index)

    adjMatrix[index]
        .withIndex()
        .filter { (childIndex, connected) -> connected && !visited.contains(childIndex) }
        .forEach { (childIndex) -> return depthSearch(g, adjMatrix, childIndex, searching, visited) }
    return null
}

fun <T>depth(g: Graph<T>, searching: T): Node<T>? {
   val adjMatrix = g.adjacencyMatrix()
    return depthSearch(g, adjMatrix, 0, searching, mutableListOf())
}
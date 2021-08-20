package graph

fun <T> generateKGraph(counter: Iterator<T>): Graph<T> {
    val g = Graph<T>(mutableListOf(), mutableListOf())

    for (index in counter) {
        val indexNode = Node(index)
        for (node in g.nodes) {
            val e = Edge(from = indexNode, to = node)
            g.edges.add(e)
        }
        g.nodes.add(indexNode)
    }
    return g
}

fun <T> createPath(nodes: List<Node<T>>): List<Edge<T>> {
    val path = mutableListOf<Edge<T>>()
    for (node in 0 until nodes.size - 1) {
        path.add(Edge(nodes[node], nodes[node + 1]))
    }
    return path
}

fun <T> generateNTree(
    depth: Int,
    width: Int,
    g: Graph<T> = Graph(mutableListOf(Node()), mutableListOf())
): Graph<T> {
    if (depth == 0) {
        return g
    }
    for (child in 1..width) {
        g.nodes.add(Node<T>())
        generateNTree<T>(depth - 1, width, g)
    }
    println(g)
    return g
}
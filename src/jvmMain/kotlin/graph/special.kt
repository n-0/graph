package graph

fun <T>generateKGraph(counter: Iterator<T>): Graph<T> {
    val g = Graph<T>(mutableListOf(), mutableListOf())

    for (index in counter) {
        val indexNode = Node(index)
        for (node in g.nodes) {
            val e =  Edge(from = indexNode, to = node)
            g.edges.add(e)
        }
        g.nodes.add(indexNode)
    }
    return g
}

fun <T>createPath(nodes: List<Node<T>>): List<Edge<T>> {
    val path = mutableListOf<Edge<T>>()
    for (node in 0 until nodes.size-1) {
        path.add(Edge(nodes[node], nodes[node+1]))
    }
    return path
}

fun <T>generateNTree(n: Int, m: Int): Graph<T> {
    val nodes = mutableListOf<Node<T>>()
    val edges = mutableListOf<Edge<T>>()
    var root = Node(null)
    if (counter.hasNext()) {
        root = Node(counter.next())
    } else {
        return Graph(mutableListOf(), mutableListOf())
    }
    for (index in 0 until m step n) {
        val branch = (0..(index % n)).map { Node(it) })

    }
}
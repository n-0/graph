package graph

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class GraphKtTest {

    @Test
    fun testGenerateKGraph() {
        val counter = 1..3
        val kGraph = generateKGraph(counter.iterator())
        for (index in counter) {
            assertEquals(2, kGraph.edges.filter { e -> e.to.value == index || e.from.value == index }.size)
        }
    }

    @Test
    fun testIsomorphism() {
        val counter = 1..3
        val kGraph1 = generateKGraph(counter.iterator())
        var nodes = mutableListOf(
            Node(1),
            Node(3),
            Node(2),
        )
        var edges = mutableListOf(
            Edge(nodes[0], nodes[1]),
            Edge(nodes[0], nodes[2]),
            Edge(nodes[1], nodes[2])
        )

        val kGraph2 = Graph(nodes, edges)
        assertTrue { isIsomorphic(kGraph1, kGraph2) }

        edges = edges.dropLast(2).toMutableList()
        nodes.add(Node(2))
        edges.add(Edge(nodes[3], nodes[2]))

        val graph3 = Graph(nodes, edges)

        val shuffledNodes = nodes.toMutableList().also { it.shuffle() }
        var shuffledEdges = edges.toMutableList()
        shuffledEdges = shuffledEdges.dropLast(1).toMutableList()
        shuffledEdges.add(Edge(nodes[2], nodes[3]))
        shuffledEdges = shuffledEdges.shuffled().toMutableList()

        val shuffledGraph = Graph(shuffledNodes, shuffledEdges)
        println(shuffledGraph)
        println(graph3)
        assertTrue { isIsomorphic(graph3, shuffledGraph) }

    }

    @Test
    fun testTree() {
        val calcSize: (Int, Int) -> Int = { d: Int, w: Int -> (0..d)
            .toList()
            .map {
                println(it)
                Math.pow(w.toDouble(), it.toDouble()).toInt()
            }.sum()
        }

        val depth = 2
        val width = 3
        val tree = generateNTree<Int>(depth, width)
        assertEquals(calcSize(depth, width), tree.nodes.size)
    }

}
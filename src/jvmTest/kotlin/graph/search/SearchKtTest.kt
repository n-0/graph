package graph.search

import graph.generateKGraph
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class SearchKtTest {

    @Test
    fun testDepthSearch() {
        val g = generateKGraph((0 until 10).iterator())
        assert(depth(g, 7)?.value == 7)
    }
}
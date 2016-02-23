package core.extensions

import org.junit.Test

import org.junit.Assert.*

/**
 */
class SetsTest {

    @Test
    fun testPermutations() {
        var res = setOf("A", "B", "C").toMutableSet().permutations()

        println(res)
        assertEquals(6, res.size)
    }
}
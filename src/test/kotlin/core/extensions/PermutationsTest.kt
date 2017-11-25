package core.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class PermutationsTest {

    @Test
    fun testPermutations() {
        val res = setOf("A", "B", "C").toMutableSet().permutations()

        println(res)
        assertEquals(6, res.size)
    }
}
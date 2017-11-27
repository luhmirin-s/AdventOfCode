package core.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
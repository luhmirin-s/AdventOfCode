package core.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

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
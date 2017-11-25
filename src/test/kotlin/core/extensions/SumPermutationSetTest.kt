package core.extensions

import org.junit.Test

import org.junit.Assert.*

/**
 */
class SumPermutationSetTest {

    @Test
    fun testGetSumPermutationSet() {
        assertEquals(4, listOf(5, 5, 10, 15, 20).getSumPermutationSet(25).count())
    }
}
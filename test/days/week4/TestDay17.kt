package days.week4

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay17 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day17().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day17().calculateAdvanced())
    }
}
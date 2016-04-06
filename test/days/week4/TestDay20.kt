package days.week4

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay20 {

    val SIMPLE_ANSWER = "776160"
    val ADVANCED_ANSWER = "786240"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day20().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day20().calculateAdvanced())
    }
}
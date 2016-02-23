package days.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay11 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day11().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day11().calculateAdvanced())
    }
}
package days.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay11 {

    val SIMPLE_ANSWER = "cqjxxyzz"
    val ADVANCED_ANSWER = "cqkaabcc"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day11().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day11().calculateAdvanced())
    }
}
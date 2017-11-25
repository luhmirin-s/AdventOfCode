package y2015.week5

import org.junit.Assert.assertEquals
import org.junit.Test
import y2015.week5.Day21

/**
 */
class TestDay21 {

    val SIMPLE_ANSWER = "121"
    val ADVANCED_ANSWER = "201"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day21().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day21().calculateAdvanced())
    }
}

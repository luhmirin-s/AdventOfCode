package y2015.week5

import org.junit.Assert.assertEquals
import org.junit.Test
import y2015.week5.Day23

/**
 */
class TestDay23 {

    val SIMPLE_ANSWER = "255"
    val ADVANCED_ANSWER = "334"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day23().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day23().calculateAdvanced())
    }
}
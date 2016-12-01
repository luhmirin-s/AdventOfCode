package days.week5

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay23 {

    var SIMPLE_ANSWER = "-1"
    val ADVANCED_ANSWER = "-1"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day23().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day23().calculateAdvanced())
    }
}
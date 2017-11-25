package y2017.week5

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay24 {

    val SIMPLE_ANSWER = "-1"
    val ADVANCED_ANSWER = "-1"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day24().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day24().calculateAdvanced())
    }
}
package days.week5

import days.week5.Day25
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay25 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day25().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day25().calculateAdvanced())
    }
}
package days.week2

import days.week2.Day9
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay9 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day9().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day9().calculateAdvanced())
    }
}
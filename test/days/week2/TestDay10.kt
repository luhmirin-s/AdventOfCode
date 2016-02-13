package days.week2

import days.week2.Day10
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay10 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day10().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day10().calculateAdvanced())
    }
}
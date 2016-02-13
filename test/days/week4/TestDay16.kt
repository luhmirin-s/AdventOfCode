package days.week4

import days.week4.Day16
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay16 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day16().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day16().calculateAdvanced())
    }
}
package days.week1

import days.week1.Day5
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay5 {

    val SIMPLE_ANSWER = "255"
    val ADVANCED_ANSWER = "55"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day5().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day5().calculateAdvanced())
    }
}
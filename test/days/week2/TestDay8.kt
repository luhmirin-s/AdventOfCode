package days.week2

import days.week2.Day8
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay8 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day8().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day8().calculateAdvanced())
    }
}
package days.week5

import days.week5.Day22
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay22 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day22().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day22().calculateAdvanced())
    }
}
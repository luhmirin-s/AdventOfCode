package days.day_5

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay5 {

    val SIMPLE_ANSWER = "255"
    val ADVANCED_ANSWER = "55"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day().calculateAdvanced())
    }
}
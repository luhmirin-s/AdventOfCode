package days.day_3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay3 {

    val SIMPLE_ANSWER = "2592"
    val ADVANCED_ANSWER = "2360"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day().calculateAdvanced())
    }
}
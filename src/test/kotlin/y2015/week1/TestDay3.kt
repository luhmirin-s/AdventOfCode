package y2015.week1

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay3 {

    val SIMPLE_ANSWER = "2592"
    val ADVANCED_ANSWER = "2360"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day3().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day3().calculateAdvanced())
    }
}
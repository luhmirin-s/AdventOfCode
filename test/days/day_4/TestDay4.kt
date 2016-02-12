package days.day_4

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay4 {

    val SIMPLE_ANSWER = "254575"
    val ADVANCED_ANSWER = "1038736"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day().calculateAdvanced())
    }
}
package y2015.week3

import org.junit.Assert.assertEquals
import org.junit.Test
import y2015.week3.Day13

/**
 */
class TestDay13 {

    val SIMPLE_ANSWER = "733"
    val ADVANCED_ANSWER = "725"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day13().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day13().calculateAdvanced())
    }
}
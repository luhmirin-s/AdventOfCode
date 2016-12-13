package days.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay13 {

    var SIMPLE_ANSWER = "86"
    val ADVANCED_ANSWER = "127"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day13().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day13().calculateAdvanced())
    }
}
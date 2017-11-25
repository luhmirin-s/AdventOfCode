package y2016.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay11 {

    var SIMPLE_ANSWER = "31"
    val ADVANCED_ANSWER = "55"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day11().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day11().calculateAdvanced())
    }
}
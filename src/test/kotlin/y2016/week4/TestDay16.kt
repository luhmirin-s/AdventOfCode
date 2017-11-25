package y2016.week4

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay16 {

    var SIMPLE_ANSWER = "11100111011101111"
    val ADVANCED_ANSWER = "10001110010000110"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day16().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day16().calculateAdvanced())
    }
}
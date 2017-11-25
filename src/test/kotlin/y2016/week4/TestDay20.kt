package y2016.week4

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay20 {

    var SIMPLE_ANSWER = "4793564"
    val ADVANCED_ANSWER = "146"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day20().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day20().calculateAdvanced())
    }
}
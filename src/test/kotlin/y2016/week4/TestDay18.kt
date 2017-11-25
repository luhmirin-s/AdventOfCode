package y2016.week4

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay18 {

    var SIMPLE_ANSWER = "2013"
    val ADVANCED_ANSWER = "20006289"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day18().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day18().calculateAdvanced())
    }
}
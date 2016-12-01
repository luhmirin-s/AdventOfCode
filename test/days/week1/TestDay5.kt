package days.week1

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay5 {

    var SIMPLE_ANSWER = "-1"
    val ADVANCED_ANSWER = "-1"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day5().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day5().calculateAdvanced())
    }
}
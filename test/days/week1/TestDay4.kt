package days.week1

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay4 {

    var SIMPLE_ANSWER = "361724"
    val ADVANCED_ANSWER = "482"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day4().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day4().calculateAdvanced())
    }
}
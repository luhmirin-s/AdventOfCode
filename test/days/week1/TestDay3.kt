package days.week1

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay3 {

    var SIMPLE_ANSWER = "869"
    val ADVANCED_ANSWER = "1544"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day3().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day3().calculateAdvanced())
    }
}
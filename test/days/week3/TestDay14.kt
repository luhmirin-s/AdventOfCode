package days.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay14 {

    var SIMPLE_ANSWER = "15168"
    val ADVANCED_ANSWER = "20864"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day14().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day14().calculateAdvanced())
    }
}
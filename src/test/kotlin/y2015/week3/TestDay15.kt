package y2015.week3

import org.junit.Assert.assertEquals
import org.junit.Test
import y2015.week3.Day15

/**
 */
class TestDay15 {

    val SIMPLE_ANSWER = "222870"
    val ADVANCED_ANSWER = "117936"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day15().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day15().calculateAdvanced())
    }
}
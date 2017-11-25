package y2016.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay12 {

    var SIMPLE_ANSWER = "318077"
    val ADVANCED_ANSWER = "9227731"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day12().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day12().calculateAdvanced())
    }
}
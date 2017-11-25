package y2016.week5

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay23 {

    var SIMPLE_ANSWER = "10890"
    val ADVANCED_ANSWER = "479007450"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day23().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day23().calculateAdvanced())
    }
}
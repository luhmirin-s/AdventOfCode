package y2016.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay15 {

    var SIMPLE_ANSWER = "203660"
    val ADVANCED_ANSWER = "2408135"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day15().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day15().calculateAdvanced())
    }
}
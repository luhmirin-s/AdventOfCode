package days.week5

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 */
class TestDay25 {

    var SIMPLE_ANSWER = "-1"
    val ADVANCED_ANSWER = "-1"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day25().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertTrue(true)
        // this one is for free
    }
}
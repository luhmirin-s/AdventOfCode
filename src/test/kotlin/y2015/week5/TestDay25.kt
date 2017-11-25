package y2015.week5

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import y2015.week5.Day25

/**
 */
class TestDay25 {

    val SIMPLE_ANSWER = "9132360"
    val ADVANCED_ANSWER = "0"

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
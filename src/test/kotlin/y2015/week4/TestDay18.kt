package y2015.week4

import org.junit.Assert.assertEquals
import org.junit.Test
import y2015.week4.Day18

/**
 */
class TestDay18 {

    val SIMPLE_ANSWER = "768"
    val ADVANCED_ANSWER = "781"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day18().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day18().calculateAdvanced())
    }
}
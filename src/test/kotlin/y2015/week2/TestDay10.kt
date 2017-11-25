package y2015.week2

import org.junit.Assert.assertEquals
import org.junit.Test
import y2015.week2.Day10

/**
 */
class TestDay10 {

    val SIMPLE_ANSWER = "360154"
    val ADVANCED_ANSWER = "5103798"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day10().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day10().calculateAdvanced())
    }
}
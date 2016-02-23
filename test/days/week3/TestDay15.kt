package days.week3

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay15 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day15().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day15().calculateAdvanced())
    }
}
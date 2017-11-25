package y2015.week2

import org.junit.Assert.assertEquals
import org.junit.Test
import y2015.week2.Day7

/**
 */
class TestDay7 {

    val SIMPLE_ANSWER = "3176"
    val ADVANCED_ANSWER = "14710"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day7().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day7().calculateAdvanced())
    }
}
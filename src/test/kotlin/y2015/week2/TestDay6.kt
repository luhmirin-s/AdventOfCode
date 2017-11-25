package y2015.week2

import org.junit.Assert.assertEquals
import org.junit.Test
import y2015.week2.Day6

/**
 */
class
TestDay6 {

    val SIMPLE_ANSWER = "377891"
    val ADVANCED_ANSWER = "14110788"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day6().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day6().calculateAdvanced())
    }
}
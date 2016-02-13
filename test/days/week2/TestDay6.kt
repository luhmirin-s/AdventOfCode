package days.week2

import days.week2.Day6
import org.junit.Assert.assertEquals
import org.junit.Test

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
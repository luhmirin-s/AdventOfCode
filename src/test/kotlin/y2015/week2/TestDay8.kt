package y2015.week2

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay8 {

    val SIMPLE_ANSWER = "1371"
    val ADVANCED_ANSWER = "2117"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day8().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day8().calculateAdvanced())
    }
}
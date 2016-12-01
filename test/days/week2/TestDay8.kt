package days.week2

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay8 {

    var SIMPLE_ANSWER = "-1"
    val ADVANCED_ANSWER = "-1"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day8().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day8().calculateAdvanced())
    }
}
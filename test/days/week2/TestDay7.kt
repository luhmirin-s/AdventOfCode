package days.week2

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay7 {

    var SIMPLE_ANSWER = "110"
    val ADVANCED_ANSWER = "242"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day7().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day7().calculateAdvanced())
    }

}
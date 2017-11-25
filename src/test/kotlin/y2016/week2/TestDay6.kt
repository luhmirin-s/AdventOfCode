package y2016.week2

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class
TestDay6 {

    var SIMPLE_ANSWER = "kqsdmzft"
    val ADVANCED_ANSWER = "tpooccyo"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day6().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day6().calculateAdvanced())
    }
}
package y2016.week5

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay24 {

    var SIMPLE_ANSWER = "412"
    val ADVANCED_ANSWER = "664"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day24().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day24().calculateAdvanced())
    }
}
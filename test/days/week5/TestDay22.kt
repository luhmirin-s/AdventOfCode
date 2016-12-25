package days.week5

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay22 {

    var SIMPLE_ANSWER = "910"
    val ADVANCED_ANSWER = "222"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day22().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day22().calculateAdvanced())
    }
}
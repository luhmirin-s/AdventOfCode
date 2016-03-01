package days.week4

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay16 {

    val SIMPLE_ANSWER = "40"
    val ADVANCED_ANSWER = "241"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day16().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day16().calculateAdvanced())
    }
}
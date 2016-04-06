package days.week4

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay19 {

    val SIMPLE_ANSWER = "535"
    val ADVANCED_ANSWER = "212"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day19().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day19().calculateAdvanced())
    }
}
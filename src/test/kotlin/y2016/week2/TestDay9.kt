package y2016.week2

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 */
class TestDay9 {

    var SIMPLE_ANSWER = "107035"
    val ADVANCED_ANSWER = "11451628995"

    @Test
    fun testCalculate() {
        assertEquals(SIMPLE_ANSWER, Day9().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        assertEquals(ADVANCED_ANSWER, Day9().calculateAdvanced())
    }


}
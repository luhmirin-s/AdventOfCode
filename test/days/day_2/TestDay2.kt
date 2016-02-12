package days.day_2

import org.junit.Assert
import org.junit.Test

/**
 */
class TestDay2 {

    val SIMPLE_ANSWER = "0"
    val ADVANCED_ANSWER = "0"

    @Test
    fun testCalculate() {
        Assert.assertEquals(SIMPLE_ANSWER, Day().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        Assert.assertEquals(ADVANCED_ANSWER, Day().calculateAdvanced())
    }
}
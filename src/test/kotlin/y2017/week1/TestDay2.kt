package y2017.week1

import org.junit.Assert
import org.junit.Test

/**
 */
class TestDay2 {

    val SIMPLE_ANSWER = "-1"
    val ADVANCED_ANSWER = "-1"

    @Test
    fun testCalculate() {
        Assert.assertEquals(SIMPLE_ANSWER, Day2().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        Assert.assertEquals(ADVANCED_ANSWER, Day2().calculateAdvanced())
    }
}
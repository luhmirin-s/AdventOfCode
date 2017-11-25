package y2016.week1

import org.junit.Assert
import org.junit.Test

/**
 */
class TestDay2 {

    var SIMPLE_ANSWER = "78293"
    val ADVANCED_ANSWER = "AC8C8"

    @Test
    fun testCalculate() {
        Assert.assertEquals(SIMPLE_ANSWER, Day2().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        Assert.assertEquals(ADVANCED_ANSWER, Day2().calculateAdvanced())
    }
}
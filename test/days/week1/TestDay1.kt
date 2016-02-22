package days.week1

import org.junit.Assert
import org.junit.Test

/**
 */
class TestDay1 {

    val SIMPLE_ANSWER = "138"
    val ADVANCED_ANSWER = "1771"

    @Test
    fun testCalculate() {
        Assert.assertEquals(SIMPLE_ANSWER, Day1().calculate())
    }

    @Test
    fun testCalculateAdvanced() {
        Assert.assertEquals(ADVANCED_ANSWER, Day1().calculateAdvanced())
    }
}
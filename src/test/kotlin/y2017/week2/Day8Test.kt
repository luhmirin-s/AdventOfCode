package y2017.week2

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day8Test {

    private val input = listOf<String>(
        "b inc 5 if a > 1",
        "a inc 1 if b < 5",
        "c dec -10 if a >= 1",
        "c inc -20 if c == 10"
    )

    @Test
    fun calculateWithGiven() {
        Day8(input).calculate().should.equal("1")
    }

    @Test
    fun calculateAdvancedWithGiven() {
        Day8(input).calculateAdvanced().should.equal("10")
    }

}
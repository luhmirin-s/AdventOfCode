package y2017.week3

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day13Test {

    private val input = listOf(
        "0: 3",
        "1: 2",
        "4: 4",
        "6: 4"
    )

    @Test
    fun calculate() {
        Day13(input).calculate().should.equal("24")
    }

    @Test
    fun calculateAdvanced() {
        Day13(input).calculateAdvanced().should.equal("10")
    }
}
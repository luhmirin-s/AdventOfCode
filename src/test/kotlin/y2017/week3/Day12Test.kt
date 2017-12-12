package y2017.week3

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day12Test {

    val input = listOf(
        "0 <-> 2",
        "1 <-> 1",
        "2 <-> 0, 3, 4",
        "3 <-> 2, 4",
        "4 <-> 2, 3, 6",
        "5 <-> 6",
        "6 <-> 4, 5"
    )

    @Test
    fun calculate() {
        Day12(input).calculate().should.equal("6")
    }

    @Test
    fun calculateAdvanced() {
        Day12(input).calculateAdvanced().should.equal("2")
    }
}
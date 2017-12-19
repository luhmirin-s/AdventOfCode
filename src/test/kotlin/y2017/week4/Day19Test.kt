package y2017.week4

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day19Test {

    val input = listOf(
        "     |          ",
        "     |  +--+    ",
        "     A  |  C    ",
        " F---|----E|--+ ",
        "     |  |  |  D ",
        "     +B-+  +--+ ",
        "                "
    )

    @Test
    fun calculate() {
        Day19(input).calculate().should.equal("ABCDEF")
    }

    @Test
    fun calculateAdvanced() {
        Day19(input).calculateAdvanced().should.equal("38")
    }
}
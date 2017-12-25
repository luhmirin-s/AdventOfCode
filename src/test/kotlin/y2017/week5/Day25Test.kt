package y2017.week5

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day25Test {
    private val input = listOf(
        "Begin in state A.",
        "Perform a diagnostic checksum after 6 steps.",
        "",
        "In state A:",
        "  If the current value is 0:",
        "    - Write the value 1.",
        "    - Move one slot to the right.",
        "    - Continue with state B.",
        "  If the current value is 1:",
        "    - Write the value 0.",
        "    - Move one slot to the left.",
        "    - Continue with state B.",
        "",
        "  In state B:",
        "  If the current value is 0:",
        "    - Write the value 1.",
        "    - Move one slot to the left.",
        "    - Continue with state A.",
        "  If the current value is 1:",
        "    - Write the value 1.",
        "    - Move one slot to the right.",
        "    - Continue with state A."
    )

    @Test
    fun calculate() {
        Day25(input).calculate().should.equal("3")
    }
}

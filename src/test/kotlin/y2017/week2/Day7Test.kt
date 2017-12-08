package y2017.week2

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day7Test {

    private val input = listOf(
        "pbga (66)",
        "xhth (57)",
        "ebii (61)",
        "havc (66)",
        "ktlj (57)",
        "fwft (72) -> ktlj, cntj, xhth",
        "qoyq (66)",
        "padx (45) -> pbga, havc, qoyq",
        "tknk (41) -> ugml, padx, fwft",
        "jptl (61)",
        "ugml (68) -> gyxo, ebii, jptl",
        "gyxo (61)",
        "cntj (57)"
    )

    @Test
    fun calculateForGiven() {
        Day7(input).calculate().should.equal("tknk")
    }

    @Test
    fun calculateAdvancedForGiven() {
        Day7(input).calculateAdvanced().should.equal("60")
    }

}
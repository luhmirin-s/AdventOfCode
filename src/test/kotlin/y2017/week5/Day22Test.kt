package y2017.week5

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day22Test {

    private val input = listOf(
        "..#",
        "#..",
        "..."
    )

    @Test
    fun calculate() {
        Day22(input).calculate().should.equal("5587")
    }

    @Test
    fun calculateAdvanced() {
        Day22(input).calculateAdvanced().should.equal("2511944")
    }
}


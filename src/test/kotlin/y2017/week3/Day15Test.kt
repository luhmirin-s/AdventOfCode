package y2017.week3

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day15Test {

    @Test
    fun calculate() {
        Day15(listOf("65", "8921")).calculate().should.equal("588")
    }

    @Test
    fun calculateAdvanced() {
        Day15(listOf("65", "8921")).calculateAdvanced().should.equal("309")
    }
}
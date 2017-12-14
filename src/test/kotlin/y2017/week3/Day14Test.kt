package y2017.week3

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day14Test {

    @Test
    fun calculate() {
        Day14(listOf("flqrgnkx")).calculate().should.equal("8108")
    }

    @Test
    fun calculateAdvanced() {
        Day14(listOf("flqrgnkx")).calculateAdvanced().should.equal("1242")
    }
}
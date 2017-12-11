package y2017.week3

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day11Test {

    @Test
    fun calculate() {
        Day11(listOf("ne,ne,ne")).calculate().should.equal("3")
        Day11(listOf("ne,ne,sw,sw")).calculate().should.equal("0")
        Day11(listOf("ne,ne,s,s")).calculate().should.equal("2")
        Day11(listOf("se,sw,se,sw,sw")).calculate().should.equal("3")
    }
}
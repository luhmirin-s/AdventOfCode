package y2017.week2

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day10Test {

    @Test
    fun calculateAdvanced() {
        Day10(listOf("")).calculateAdvanced().should.equal("a2582a3a0e66e6e86e3812dcb672a272")
        Day10(listOf("AoC 2017")).calculateAdvanced().should.equal("33efeb34ea91902bb2f59c9920caa6cd")
        Day10(listOf("1,2,3")).calculateAdvanced().should.equal("3efbe78a8d82f29979031a4aa0b16a9d")
        Day10(listOf("1,2,4")).calculateAdvanced().should.equal("63960835bcdc130f0b66d7ff4f6a5a8e")
    }
}
package y2017.week4

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day17Test {

    @Test
    fun calculate() {
        Day17(listOf("3")).calculate().should.equal("638")
    }
}
package y2017.week2

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day6Test {

    @Test
    fun calculateWithGiven() {
        Day6(listOf("0\t2\t7\t0")).calculate().should.equal("5")
    }

    @Test
    fun calculateAdvancedWithGiven() {
        Day6(listOf("0\t2\t7\t0")).calculateAdvanced().should.equal("4")
    }
}
package y2017.week1

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

class Day5Test {

    @Test
    fun calculateWithGiven() {
       Day5(listOf("0", "3", "0", "1", "-3")).calculate().should.equal("5")
    }

    @Test
    fun calculateAdvancedWithGiven() {
        Day5(listOf("0", "3", "0", "1", "-3")).calculateAdvanced().should.equal("10")
    }
}
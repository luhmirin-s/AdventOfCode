package y2017.week1

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day3Test {

    @Test
    fun calculateForGivenSample() {
        Day3(listOf("1")).calculate().should.equal("0")
        Day3(listOf("12")).calculate().should.equal("3")
        Day3(listOf("23")).calculate().should.equal("2")
        Day3(listOf("1024")).calculate().should.equal("31")
    }

    @Test
    fun calculateAdvancedForGivenSample() {
        Day3(listOf("800")).calculateAdvanced().should.equal("806")
    }
}
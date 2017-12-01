package y2017.week1

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day1Test {

    @Test
    fun calculateWithGivenSamples() {
        Day1(listOf("1122")).calculate().should.equal("3")
        Day1(listOf("1111")).calculate().should.equal("4")
        Day1(listOf("1234")).calculate().should.equal("0")
        Day1(listOf("91212129")).calculate().should.equal("9")
    }

    @Test
    fun calculateAdvancedWithGivenSamples() {
        Day1(listOf("1212")).calculateAdvanced().should.equal("6")
        Day1(listOf("1221")).calculateAdvanced().should.equal("0")
        Day1(listOf("123425")).calculateAdvanced().should.equal("4")
        Day1(listOf("123123")).calculateAdvanced().should.equal("12")
        Day1(listOf("12131415")).calculateAdvanced().should.equal("4")
    }

}


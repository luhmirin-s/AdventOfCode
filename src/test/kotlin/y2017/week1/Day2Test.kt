package y2017.week1

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day2Test {

    @Test
    fun calculateForGivenSample() {
        val input = listOf<String>(
            "5\t1\t9\t5",
            "7\t5\t3",
            "2\t4\t6\t8"
        )
        Day2(input).calculate().should.equal("18")
    }

    @Test
    fun calculateAdvancedGivenSample() {
        val input = listOf<String>(
            "5\t9\t2\t8",
            "9\t4\t7\t3",
            "3\t8\t6\t5"
        )
        Day2(input).calculateAdvanced().should.equal("9")
    }
}
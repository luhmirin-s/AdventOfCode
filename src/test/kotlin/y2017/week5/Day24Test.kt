package y2017.week5

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day24Test {

    private val input = listOf(
        "0/2",
        "2/2",
        "2/3",
        "3/4",
        "3/5",
        "0/1",
        "10/1",
        "9/10"
    )

    @Test
    fun calculate() {
        Day24(input).calculate().should.equal("31")
    }

    @Test
    fun calculateAdvanced() {
        Day24(input).calculateAdvanced().should.equal("19")
    }
}


package y2017.week4

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

internal class Day18Test {

    @Test
    fun calculate() {
        Day18(listOf(
            "set a 1",
            "add a 2",
            "mul a a",
            "mod a 5",
            "snd a",
            "set a 0",
            "rcv a",
            "jgz a -1",
            "set a 1",
            "jgz a -2"
        )).calculate().should.equal("4")
    }

    @Test
    fun calculateAdvanced() {
        Day18(listOf(
            "snd 1",
            "snd 2",
            "snd p",
            "rcv a",
            "rcv b",
            "rcv c",
            "rcv d"
        )).calculateAdvanced().should.equal("3")
    }
}
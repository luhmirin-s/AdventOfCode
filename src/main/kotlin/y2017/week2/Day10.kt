package y2017.week2

import core.AbstractDay
import y2017.KnotHash

class Day10(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine.split(",").map { it.toInt() }
        .let { KnotHash().mixUpTimes(it, 1) }
        .let { it[0] * it[1] }
        .toString()

    override fun calculateAdvanced() = inputFirstLineChars
        .map { it.toInt() }
        .let { KnotHash().hash(it) }

}
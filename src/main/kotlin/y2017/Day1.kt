package y2017

import core.AbstractDay
import core.extensions.toIntValue

class Day1(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        return inputFirstLine.toIntListWithTail()
            .filterNotSameAtStep()
            .sum()
            .toString()
    }

    override fun calculateAdvanced(): String {
        val half = inputFirstLine.length / 2
        return inputFirstLine.toIntListWithTail(half)
            .filterNotSameAtStep(half)
            .sum()
            .toString()
    }

    private fun List<Int>.filterNotSameAtStep(step: Int = 1): List<Int> = windowed(step + 1) {
        if (it.first() == it.last()) it.first() else 0
    }

    private fun String.toIntListWithTail(step: Int = 1): List<Int> = toCharArray()
        .map { it.toIntValue() }
        .let { it + it.subList(0, step) }
}

package y2015.week3

import core.AbstractDay
import core.extensions.toIntOrElse

class Day12(input: List<String>) : AbstractDay(input) {

    private val TEXT_PATTERN = Regex("\".*\"")
    private val CHAR_PATTERN = Regex("[\\[\\]\\{\\}:,]")

    override fun calculate(): String = input.convertAndSum()

    override fun calculateAdvanced(): String = input.convertAndSum()

    private fun List<String>.convertAndSum() = this
        .map { it.replace(TEXT_PATTERN, "").replace(CHAR_PATTERN, "").trim() }
        .filter { it.isNotEmpty() }
        .map { it.toIntOrElse(0) }
        .sum().toString()
}
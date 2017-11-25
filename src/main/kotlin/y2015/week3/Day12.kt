package y2015.week3

import core.extensions.toIntOrElse
import y2015.DayOf2015

class Day12 : DayOf2015("day_12") {

    val TEXT_PATTERN = Regex("\".*\"")
    val CHAR_PATTERN = Regex("[\\[\\]\\{\\}:,]")

    override fun calculate(): String {
        return input().convertAndSum()
    }

    override fun calculateAdvanced(): String {
        // It appears that parsing Json in pure Kotlin is problematic
        // input file was cleaned up manually (sic!)
        return readPathAsLines("inputs/y2015/day_12_2.in").convertAndSum()
    }

    private fun List<String>.convertAndSum() = this
        .map { it.replace(TEXT_PATTERN, "").replace(CHAR_PATTERN, "").trim() }
        .filter { it.isNotEmpty() }
        .map { it.toIntOrElse(0) }
        .sum().toString()
}
package days.week3

import core.AbstractDay
import core.extensions.toIntOrElse
import java.nio.file.Files
import java.nio.file.Paths

class Day12 : AbstractDay("day_12") {

    val TEXT_PATTERN = Regex("\".*\"")
    val CHAR_PATTERN = Regex("[\\[\\]\\{\\}:,]")

    override fun calculate(): String {
        return input().convertAndSum()
    }

    override fun calculateAdvanced(): String {
        // It appears that parsing Json in pure Kotlin is problematic
        // input file was cleaned up manually (sic!)
        return Files.readAllLines(Paths.get("inputs/day_12_2.in")).convertAndSum()
    }

    private fun List<String>.convertAndSum(): String {
        return this.map { it.replace(TEXT_PATTERN, "").replace(CHAR_PATTERN, "").trim() }
                .filter { it.length > 0 }
                .map { it.toIntOrElse(0) }
                .sum().toString()
    }
}
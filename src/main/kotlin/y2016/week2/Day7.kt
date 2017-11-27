package y2016.week2

import core.AbstractDay
import java.util.regex.Pattern


class Day7(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        return input.map { it.breakLines() }
            .filter { it.hasTls() }
            .count().toString()
    }

    override fun calculateAdvanced(): String {
        return input.map { it.breakLines() }
            .filter { it.hasSsl() }
            .count().toString()
    }


    private data class BrokenLine(val ips: List<String>, val hypers: List<String>)

    private fun String.breakLines(): BrokenLine {
        val ips = mutableListOf<String>()
        val hypers = mutableListOf<String>()

        val strs = this.split(Regex("[\\[|\\]]"))
        ips.add(strs[0])
        (1..(strs.size - 1) step 2).forEach { i ->
            hypers.add(strs[i])
            ips.add(strs[i + 1])
        }

        return BrokenLine(ips, hypers)
    }

    private val ABBA = Regex(".*(.)(.)\\2\\1.*")
    private val AAAA = Regex(".*(.)\\1\\1\\1.*")

    private fun BrokenLine.hasTls() =
        this.ips.any { it.matches(ABBA) && !it.matches(AAAA) }
            && this.hypers.none { it.matches(ABBA) }


    private fun BrokenLine.hasSsl() = this.ips.flatMap { it.allAbas() }
        .intersect(this.hypers.flatMap { it.allAbas() }.map { it.reverseAba() })
        .isNotEmpty()

    private fun String.allAbas(): List<String> {
        val allMatches = mutableSetOf<String>()
        val pattern = Pattern.compile("(.).\\1").matcher(this)

        for (i in 0..this.length - 1) {
            for (j in i + 1..this.length) {
                pattern.region(i, j)
                if (pattern.find()) allMatches.add(pattern.group())
            }
        }
        return allMatches.toList()
    }

    private fun String.reverseAba() = "${this[1]}${this[0]}${this[1]}"
}
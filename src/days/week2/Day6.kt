package days.week2

import core.AbstractDay
import core.joinWithoutSpaces
import kotlin.comparisons.compareBy

class Day6 : AbstractDay("week2/day_6") {

    override fun calculate(): String {
        return input().toCharDistribution(8)
                .map { it.maxWith<Char, Int>(compareBy { it.value })?.key ?: '_' }
                .joinWithoutSpaces()
    }

    override fun calculateAdvanced(): String {
        return input().toCharDistribution(8)
                .map { it.minWith<Char, Int>(compareBy { it.value })?.key ?: '_' }
                .joinWithoutSpaces()
    }

    private fun List<String>.toCharDistribution(lineLength: Int): List<MutableMap<Char, Int>> {
        val charMaps = mutableListOf<MutableMap<Char, Int>>()
        (0..(lineLength - 1)).forEach { charMaps.add(mutableMapOf<Char, Int>()) }

        this.forEach { line ->
            line.toList().forEachIndexed { i, char ->
                val value = charMaps[i].getOrPut(char, { 0 })
                charMaps[i].put(char, value + 1)
            }
        }
        return charMaps.toList()
    }

}
package y2016.week2

import core.AbstractDay
import core.extensions.joinWithoutSpaces

class Day6(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.toCharDistribution(8)
        .map { it.maxWith(compareBy { it.value })?.key ?: '_' }
        .joinWithoutSpaces()

    override fun calculateAdvanced(): String = input.toCharDistribution(8)
        .map { it.minWith(compareBy { it.value })?.key ?: '_' }
        .joinWithoutSpaces()

    private fun List<String>.toCharDistribution(lineLength: Int): List<MutableMap<Char, Int>> {
        val charMaps = mutableListOf<MutableMap<Char, Int>>()
        (0..(lineLength - 1)).forEach { charMaps.add(mutableMapOf()) }

        this.forEach { line ->
            line.toList().forEachIndexed { i, char ->
                val value = charMaps[i].getOrPut(char, { 0 })
                charMaps[i].put(char, value + 1)
            }
        }
        return charMaps.toList()
    }

}
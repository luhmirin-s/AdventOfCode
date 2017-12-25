package y2015

import core.AbstractDay

class Day1(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        var floor = 0

        inputFirstLineChars.forEachIndexed { _, c ->
            floor += c.handleSymbol()
        }
        return floor.toString()
    }

    override fun calculateAdvanced(): String {
        var floor = 0
        var firstBasement = -1

        inputFirstLineChars.forEachIndexed { i, c ->
            floor += c.handleSymbol()
            if (firstBasement < 0 && floor < 0) {
                firstBasement = i + 1 // because base 0 index
                return@forEachIndexed
            }
        }
        return firstBasement.toString()
    }

    private fun Char.handleSymbol(): Int = when (this) {
        '(' -> 1
        ')' -> -1
        else -> 0
    }

}

package days.day_1

import core.AbstractDay

class Day : AbstractDay("day_1") {

    override fun calculate(): String {
        var floor = 0

        inputFirstLineChars().forEachIndexed { i, c ->
            floor += c.handleSymbol()
        }
        return floor.toString()
    }

    override fun calculateAdvanced(): String {
        var floor = 0
        var firstBasement = -1

        inputFirstLineChars().forEachIndexed { i, c ->
            floor += c.handleSymbol()
            if (firstBasement < 0 && floor < 0) {
                firstBasement = i + 1 // because base 0 index
                return@forEachIndexed
            }
        }
        return firstBasement.toString()
    }

    private fun Char.handleSymbol(): Int {
        when (this) {
            '(' -> return 1
            ')' -> return -1
            else -> return 0
        }
    }

}

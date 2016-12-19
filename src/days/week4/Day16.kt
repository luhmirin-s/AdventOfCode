package days.week4

import core.AbstractDay
import core.isOdd
import core.joinWithoutSpaces
import core.toIndex

class Day16 : AbstractDay("week4/day_16") {

    override fun calculate(): String {
        return inputFirstLine().expand(272).toCheckSum()
    }

    override fun calculateAdvanced(): String {
        return inputFirstLine().expand(35651584).toCheckSum()
    }


    private fun String.expand(maxLength: Int): String {
        var result = this.expandOne()
        while (result.length < maxLength) {
            result = result.expandOne()
        }
        return result.substring(0..maxLength.toIndex())
    }

    private fun String.expandOne() = "${this}0${this.reversed().map { if (it == '0') '1' else '0' }.joinWithoutSpaces()}"

    private fun String.toPairs(): List<String> {
        val chars = this.toCharArray()
        val result = mutableListOf<String>()
        (0..chars.size.toIndex() step 2).forEach { i -> result.add("${chars[i]}${chars[i + 1]}") }
        return result
    }

    private fun List<String>.reduce() = this.map {
        when (it) {
            "00", "11" -> '1'
            else -> '0'
        }
    }.joinWithoutSpaces()

    private fun String.toCheckSum(): String {
        var result = this
        do {
            result = result.toPairs().reduce()
        } while (!result.length.isOdd())
        return result
    }
}
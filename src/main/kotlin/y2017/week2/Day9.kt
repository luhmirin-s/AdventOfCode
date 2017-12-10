package y2017.week2

import core.AbstractDay
import core.extensions.IntCollector
import core.extensions.collect

class Day9(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLineChars
        .removeNots()
        .removeGarbage()
        .getScore()
        .toString()

    override fun calculateAdvanced(): String = inputFirstLineChars
        .removeNots()
        .countGarbage()
        .toString()


    private fun List<Char>.removeNots(): List<Char> = mutableListOf<Char>().also {
        var i = 0
        while (i < size) {
            if (this[i] == '!') i += 2
            else {
                it.add(this[i])
                i++
            }
        }
    }

    private fun List<Char>.removeGarbage() = mutableListOf<Char>().also {
        var i = 0
        while (i < size) {
            if (this[i] == '<') i += this.subList(i, size).indexOf('>') + 1
            else {
                it.add(this[i])
                i++
            }
        }
    }

    private fun List<Char>.getScore(): Int {
        var depth = 0
        return this.collect(IntCollector(0)) { i, c ->
            when (c) {
                '{' -> {
                    depth++
                    i.value += depth
                }
                '}' -> depth--
            }
        }.value
    }

    private fun List<Char>.countGarbage(): Int {
        var totalGarbageSize = 0
        var i = 0
        while (i < size) {
            if (this[i] == '<') {
                val garbageSize = this.subList(i, size).indexOf('>') - 1
                totalGarbageSize += garbageSize
                i += garbageSize + 1
            } else {
                i++
            }
        }
        return totalGarbageSize
    }
}

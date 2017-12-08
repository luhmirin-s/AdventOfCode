package y2015.week3

import core.AbstractDay

class Day11(input: List<String>) : AbstractDay(input) {

    private val LETTERS = listOf(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    private val FORBIDDEN = listOf(LETTERS.indexOf('i'), LETTERS.indexOf('l'), LETTERS.indexOf('o'))


    override fun calculate(): String = inputFirstLineChars
        .mapToInt()
        .findNextPassword()
        .toFinalString()

    override fun calculateAdvanced(): String = inputFirstLineChars
        .mapToInt()
        .findNextPassword()
        .findNextPassword()
        .toFinalString()


    private fun List<Char>.mapToInt(): MutableList<Int> = map { LETTERS.indexOf(it) }.reversed().toMutableList()

    private fun MutableList<Int>.toFinalString(): String = map { LETTERS[it] }.reversed().joinToString(separator = "")


    private fun MutableList<Int>.findNextPassword(): MutableList<Int> {
        val stringReversed = this

        do {
            stringReversed.inc()
        } while (!stringReversed.match())

        return stringReversed
    }

    private fun MutableList<Int>.inc() {
        this[0] = this[0].inc()
        for (i in 0..(this.size - 1)) {
            val overflow = this[i] / LETTERS.size > 0
            if (overflow) {
                this[i] = 0
                this[i + 1] = this[i + 1].inc()
            } else break
        }
    }

    private fun MutableList<Int>.match(): Boolean {
        return !this.any { FORBIDDEN.contains(it) }
            && this.hasTwoPairs()
            && this.hasThreeDecreasing()
    }

    private fun MutableList<Int>.hasTwoPairs(): Boolean {
        var pairs = 0
        var i = 0
        while (i < this.size - 1) {
            if (this[i] == this[i + 1]) {
                pairs++
                i++
            }
            i++
        }
        return pairs >= 2
    }

    private fun MutableList<Int>.hasThreeDecreasing(): Boolean =
        (2..this.size).any { this[it - 2] == this[it - 1] + 1 && this[it - 2] == this[it] + 2 }
}
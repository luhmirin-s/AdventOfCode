package days.week1

import core.AbstractDay

class Day5 : AbstractDay("day_5") {

    override fun calculate(): String {
        return input()
                .filter { str -> str.isNice() }
                .count()
                .toString()
    }

    override fun calculateAdvanced(): String {
        return input()
                .filter { str -> str.isNiceAdvanced() }
                .count()
                .toString()
    }


    // ===================

    private fun String.isNice(): Boolean {
        return this.hasAtLeastVowels(3)
                && this.hasDoubleLetters()
                && !this.containsAnyOfList("ab", "cd", "pq", "xy")
    }

    private val VOWELS = "aeiou"
    private fun String.hasAtLeastVowels(amount: Int): Boolean {
        return this.count { c -> VOWELS.contains(c) } >= amount
    }

    private val DOUBLE_LETTERS_PATTERN = ".*(.)\\1.*".toRegex()
    private fun String.hasDoubleLetters(): Boolean {
        return this.matches(DOUBLE_LETTERS_PATTERN)
    }

    private fun String.containsAnyOfList(vararg list: String): Boolean {
        list.forEach {
            if (this.contains(it)) return true
        }
        return false
    }


    // ===================

    private fun String.isNiceAdvanced(): Boolean {
        val b1 = this.hasSameLetterDividedByOne()
        val b2 = this.hasRepeatingLetterPairs()
        return b1 && b2
    }

    private val DOUBLE_LETTERS_DIVIDED_PATTERN = ".*(.).\\1.*".toRegex()
    private fun String.hasSameLetterDividedByOne(): Boolean {
        return this.matches(DOUBLE_LETTERS_DIVIDED_PATTERN)
    }

    private val REPEATING_PAIRS_PATTERN = ".*(..).*\\1.*".toRegex()
    private fun String.hasRepeatingLetterPairs(): Boolean {
        return this.matches(REPEATING_PAIRS_PATTERN)
    }
}
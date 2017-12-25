package y2016

import core.AbstractDay

class Day19(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        // http://www.dailymail.co.uk/sciencetech/article-3939460/Could-survive-suicide-circle-Roman-math-puzzle-revealed.html
        val input = inputFirstLine.toInt()
        val lowerBorder = input.lowerBorder(2)
        return ((input - lowerBorder) * 2 + 1).toString()
    }

    override fun calculateAdvanced(): String {
        val input = inputFirstLine.toInt()

        val lowBorder = input.lowerBorder(3)
        val reminder = input - lowBorder

        return when {
            reminder == 0 -> lowBorder
            reminder <= lowBorder -> reminder
            else -> lowBorder + (reminder - lowBorder) * 2
        }.toString()

    }

    private fun Int.lowerBorder(base: Int): Int {
        var power = -1
        var x = this
        do {
            x /= base
            power++
        } while (x > 0)
        return Math.pow(base.toDouble(), power.toDouble()).toInt()
    }
}
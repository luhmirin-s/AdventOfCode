package y2015

import core.AbstractDay

class Day25(input: List<String>) : AbstractDay(input) {

    private val INPUT_PATTERN = ".* row (.*), column (.*)."

    override fun calculate(): String {

        val groups = Regex(INPUT_PATTERN)
            .matchEntire(inputFirstLine)
            ?.groups

        val maxRow = groups?.get(1)?.value?.toInt() ?: 0
        val maxColumn = groups?.get(2)?.value?.toInt() ?: 0

        return calculateCode(maxColumn, maxRow).toString()
    }

    override fun calculateAdvanced(): String = "(party)"

    private fun calculateCode(targetColumn: Int, targetRow: Int): Long {
        var value = 20151125L
        var column = 1
        var row = 1

        do {
            if (row == 1) {
                row = column + 1
                column = 1
            } else {
                row--
                column++
            }
            value = value.getNextValue()

        } while ((column != targetColumn) || (row != targetRow))
        return value
    }

    private fun Long.getNextValue(): Long = (this * 252533) % 33554393

}
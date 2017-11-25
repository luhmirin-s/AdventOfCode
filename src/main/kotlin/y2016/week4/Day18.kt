package y2016.week4

import core.extensions.toIndex
import y2016.DayOf2016

class Day18 : DayOf2016("week4/day_18") {

    override fun calculate(): String {
        return inputFirstLine().getCountOfSafeTiles(40).toString()
    }

    override fun calculateAdvanced(): String {
        return inputFirstLine().getCountOfSafeTiles(400000).toString()
    }


    private fun String.toTileArray() = this.toCharArray().map { it == '.' }

    private fun String.getCountOfSafeTiles(size: Int): Int {
        val rowLength = this.length.toIndex()
        var result = 0

        var previousRow = this.toTileArray()

        (1..size).forEach { index ->
            val newRow = mutableListOf<Boolean>()

            (0..rowLength).forEach { i ->
                val left = if (i == 0) true else previousRow[i - 1]
                val right = if (i == rowLength) true else previousRow[i + 1]
                newRow.add(left == right)
            }

            result += previousRow.count { it }
            previousRow = newRow
        }
        return result
    }

}
package y2016.week4

import core.extensions.toIndex
import y2016.DayOf2016

class Day20 : DayOf2016("week4/day_20") {

    val MAX = 4294967295L

    override fun calculate(): String {
        return input().parseLines()
            .removeOverlaps()
            .mergeAdjacent()
            .filter { !it.isStart }
            .first().let { it.position + 1 }
            .toString()
    }

    override fun calculateAdvanced(): String {
        return input().parseLines()
            .removeOverlaps()
            .mergeAdjacent()
            .countGaps()
            .toString()
    }


    data class Border(val isStart: Boolean, val position: Long)

    private fun List<String>.parseLines() = this
        .map { it.split("-").map(String::toLong) }
        .map { listOf(Border(true, it[0]), Border(false, it[1])) }
        .flatten()
        .sortedBy { it.position }

    private fun List<Border>.mergeAdjacent(): List<Border> {
        val list = mutableListOf<Border>()

        var i = 0
        while (i < this.size.toIndex()) {
            val current = this[i]
            val next = this[i + 1]

            if (!current.isStart && next.isStart && (next.position - current.position) == 1L) {
                i += 2
            } else {
                list.add(current)
                i++
            }
        }
        list.add(this.last())
        return list
    }

    private fun List<Border>.removeOverlaps(): List<Border> {
        val list = mutableListOf<Border>()

        var depth = 0
        this.forEach {
            if (it.isStart) {
                if (depth == 0) list.add(Border(true, it.position))
                depth++
            } else {
                depth--
                if (depth == 0) list.add(Border(false, it.position))
            }
        }
        return list
    }


    private fun List<Border>.countGaps(): Long {
        val NONE = -1L
        var lastEnd = NONE
        var result = 0L

        this.forEach {
            if (it.isStart && lastEnd != NONE) {
                result += it.position - lastEnd - 1
                lastEnd = NONE
            } else if (!it.isStart) {
                lastEnd = it.position
            }
        }
        return result + MAX - lastEnd
    }
}
package y2015.week4

import core.extensions.getSumPermutationSet
import y2015.DayOf2015

class Day17 : DayOf2015("day_17") {

    override fun calculate(): String {
        return input()
            .map { it.toInt() }
            .getSumPermutationSet(150)
            .count()
            .toString()
    }

    override fun calculateAdvanced(): String {
        val sumSet = input()
            .map { it.toInt() }
            .getSumPermutationSet(150)

        val smallestCount = sumSet.sortedBy { it.size }.first().size

        return sumSet
            .filter { it.size == smallestCount }
            .count()
            .toString()
    }
}




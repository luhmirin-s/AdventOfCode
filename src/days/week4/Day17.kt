package days.week4

import core.AbstractDay
import core.extensions.getSumPermutationSet

class Day17 : AbstractDay("day_17") {

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




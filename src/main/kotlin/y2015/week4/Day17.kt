package y2015.week4

import core.AbstractDay
import core.extensions.getSumPermutationSet

class Day17(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        return input
            .map { it.toInt() }
            .getSumPermutationSet(150)
            .count()
            .toString()
    }

    override fun calculateAdvanced(): String {
        val sumSet = input
            .map { it.toInt() }
            .getSumPermutationSet(150)

        val smallestCount = sumSet.sortedBy { it.size }.first().size

        return sumSet
            .filter { it.size == smallestCount }
            .count()
            .toString()
    }
}




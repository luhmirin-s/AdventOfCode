package y2017.week2

import core.AbstractDay
import core.extensions.incLooping

class Day6(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine.split("\t")
        .map { it.toInt() }
        .let { getHistoryWithLoop(it).size - 1 }
        .toString()

    override fun calculateAdvanced(): String = inputFirstLine.split("\t")
        .map { it.toInt() }
        .let { getHistoryWithLoop(it) }
        .let { hist -> hist.lastIndex - hist.indexOfFirst { it == hist.last() } }
        .toString()

    private fun getHistoryWithLoop(stacks: List<Int>): List<List<Int>> {
        val history = mutableListOf<List<Int>>()
        history.add(stacks)

        val size = stacks.size
        var stepStacks = stacks
        for (n in 0..100000) {
            val toDistribute = stepStacks.max() ?: 0
            val indexOfMax = stepStacks.indexOf(toDistribute)

            stepStacks = toDistribute.getDiffList(size, indexOfMax)
                .let { stepStacks.mergeStacksWithDiff(indexOfMax, it) }
                .also { if (containsAndAdd(history, it)) return history }
        }
        throw RuntimeException("Assumed range too small")
    }

    private fun Int.getDiffList(size: Int, startIndex: Int) = MutableList(size) { 0 }.also { res ->
        var d = this
        var i = startIndex.incLooping(size)
        while (d > 0) {
            res[i] = res[i] + 1
            i = i.incLooping(size)
            d--
        }
    }.toList()

    private fun List<Int>.mergeStacksWithDiff(startIndex: Int, diff: List<Int>) = List(this.size) {
        if (it == startIndex) diff[it]
        else this[it] + diff[it]
    }

    private fun containsAndAdd(history: MutableList<List<Int>>, stacks: List<Int>) = history
        .contains(stacks)
        .also { history.add(stacks) }

}
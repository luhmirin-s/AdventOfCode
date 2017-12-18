package y2017.week4

import core.AbstractDay
import core.extensions.incLooping
import java.util.*

class Day17(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine.toInt()
        .let { makeSpinLock(it, 2017) }
        .findNextAfter(2017)
        .toString()

    override fun calculateAdvanced() = inputFirstLine.toInt()
        .let { makeSpinLock(it, 50_000_000) }
        .findNextAfter(0)
        .toString()

    private fun makeSpinLock(steps: Int, count: Int): List<Int> {
        val list = LinkedList<Int>()
        var pos = 0
        for (i in 0..count) {
            list.add(pos, i)
            pos = pos.incLooping(list.size, steps + 1)
        }
        return list
    }

    private fun List<Int>.findNextAfter(i: Int) = this[indexOf(i).incLooping(size)]

}
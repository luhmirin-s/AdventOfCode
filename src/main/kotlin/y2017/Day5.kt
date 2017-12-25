package y2017

import core.AbstractDay

class Day5(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.map { it.toInt() }
        .toMutableList()
        .getStepsToJumpOut { it + 1 }
        .toString()

    override fun calculateAdvanced(): String = input.map { it.toInt() }
        .toMutableList()
        .getStepsToJumpOut { if (it >= 3) it - 1 else it + 1 }
        .toString()

    private inline fun MutableList<Int>.getStepsToJumpOut(crossinline instructionIncrement: (Int) -> Int): Int {
        var position = 0
        var steps = 0;
        while (position in indices) {
            get(position).let {
                set(position, instructionIncrement(it))
                position += it
            }
            steps++
        }
        return steps
    }
}
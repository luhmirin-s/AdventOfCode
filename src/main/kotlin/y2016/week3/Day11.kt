package y2016.week3

import core.extensions.collectIndexed
import y2016.DayOf2016

class Day11 : DayOf2016("week3/day_11") {

    /*
    All props for this goes to https://www.reddit.com/r/adventofcode/comments/5hoia9/2016_day_11_solutions/db4ccgv/
    I just translated his solution.
     */

    override fun calculate(): String {
        return input().collectState().calculateState().toString()
    }

    override fun calculateAdvanced(): String {
        return input().mapIndexed { i, s ->
            when (i) {
                0 -> "$s An elerium generator. An elerium-compatible microchip. A dilithium generator. A dilithium-compatible microchip."
                else -> s
            }
        }.collectState().calculateState().toString()
    }

    data class State(
        var result: Int = 0,
        var floor: Int = 0,
        val last: MutableMap<String, Int> = mutableMapOf(),
        val gaps: MutableMap<Int, Int> = mutableMapOf()
    )

    private val matcher = Regex("([a-z]+)(\\sgenerator|-compatible\\smicrochip)")
    private val MAX = 3

    private fun List<String>.collectState(): State {
        return this.collectIndexed(State()) { state, floor, line ->
            matcher.findAll(line).map { it.groups[0].toString() }.forEach { key ->
                state.result += (MAX - floor) * 2

                if (!state.last.containsKey(key)) {
                    state.last[key] = floor
                } else {
                    val gap = Math.abs(floor - state.last[key]!!)
                    if (gap != 0) {
                        val gapValue = state.gaps.getOrPut(gap, { 0 })
                        state.gaps[gap] = gapValue + 1
                    }
                }
            }
        }
    }

    private fun State.calculateState(): Int = when {
        last.size == 1 -> 3
        else -> {
            gaps.forEach { if (it.value % 2 == 0) result += (it.key * it.value - 1) * 2 }
            result - (MAX * 3)
        }
    }
}
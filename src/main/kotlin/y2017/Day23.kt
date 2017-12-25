package y2017

import core.AbstractDay

class Day23(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val instructions = input.map { Instruction(it.split(" ")) }
        val reg: Registry = mutableMapOf()

        var pos = 0
        var multipliers = 0
        while (pos in instructions.indices) {
            pos += instructions[pos].also {
                if (it.cmd == "mul") multipliers++
            }.execute(reg)
        }

        return multipliers.toString()
    }

    // Assembly was decompiled by reddit, not me
    // https://www.reddit.com/r/adventofcode/comments/7lms6p/2017_day_23_solutions/drngj9r/
    override fun calculateAdvanced(): String {
        val actualInput = inputFirstLine.split(" ").last().toLong()

        var b = actualInput * 100 + 100000
        val c = b + 17000

        var g: Long
        var h = 0L

        do {
            var f = 1L
            var d = 2L

            while (d * d <= b) {
                if (b % d == 0L) {
                    f = 0L
                    break
                }
                d++
            }

            if (f == 0L) h++
            g = b - c
            b += 17L
        } while (g != 0L)

        return h.toString()
    }

}

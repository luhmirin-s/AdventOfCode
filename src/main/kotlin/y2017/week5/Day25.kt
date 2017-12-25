package y2017.week5

import core.AbstractDay

class Day25(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val conditions = input.take(2).getConditions()
        val states = input.drop(3).chunked(10).map { it.parseState() }.toMap()

        val tape = mutableMapOf<Int, Int>()
        var position = 0
        var stateName = conditions.first

        for (i in 0 until conditions.second) {
            states[stateName]
                ?.let { if (tape.getOrPut(position, { 0 }) == 0) it.first else it.second }
                ?.let {
                    tape.put(position, it.write)
                    position += it.direction
                    stateName = it.nextState
                }
        }
        return tape.values.sum().toString()
    }

    override fun calculateAdvanced(): String = "Merry Christmas!"

    private fun List<String>.getConditions(): Pair<String, Int> =
        first().split(" ", ".")[3] to last().split(" ")[5].toInt()

    private data class State(
        val write: Int,
        val direction: Int,
        val nextState: String
    )
    
    private fun List<String>.parseState() = map { it.trim().split(" ", ".", ":") }.let {
        it[0][2] to Pair(
            State(
                write = it[2][4].toInt(),
                direction = if (it[3][6] == "right") 1 else -1,
                nextState = it[4][4]
            ),
            State(
                write = it[6][4].toInt(),
                direction = if (it[7][6] == "right") 1 else -1,
                nextState = it[8][4]
            )
        )
    }

}

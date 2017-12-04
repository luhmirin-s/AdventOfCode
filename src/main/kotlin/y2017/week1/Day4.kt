package y2017.week1

import core.AbstractDay

class Day4(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        return input.tokenizeLines()
            .map { it.size to it.toSet() }
            .map { it.second.size == it.first }
            .count { it }
            .toString()
    }

    override fun calculateAdvanced(): String {
        return input.tokenizeLines()
            .map { it.size to it.map { it.toCharArray().toSet() }.toSet() }
            .map { it.second.size == it.first }
            .count { it }
            .toString()
    }

    private fun List<String>.tokenizeLines(): List<List<String>> = map {
        it.split(" ").filter { it.isNotBlank() }
    }

}
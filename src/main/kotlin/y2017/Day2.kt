package y2017

import core.AbstractDay

class Day2(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input
        .map { it.splitStringToInts().getLargestDiff() }
        .sum()
        .toString()

    override fun calculateAdvanced(): String = input
        .map { it.splitStringToInts().getDivisibleResult() }
        .sum()
        .toString()

    private fun String.splitStringToInts(): List<Int> = split("\t")
        .filter { it.isNotBlank() }
        .map { it.toInt() }

    private fun List<Int>.getLargestDiff(): Int = (max() ?: 0) - (min() ?: 0)

    private fun List<Int>.getDivisibleResult(): Int {
        for (i in 0..(lastIndex - 1)) {
            for (j in (i + 1)..(lastIndex)) {
                if (get(i) % get(j) == 0) return (get(i) / get(j))
                if (get(j) % get(i) == 0) return (get(j) / get(i))
            }
        }
        throw RuntimeException("no divisible pair in line, check you input")
    }
}

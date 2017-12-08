package y2016.week1


import core.AbstractDay
import core.extensions.toListOfInts

class Day3(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.map(String::toListOfInts)
        .filter { it.isValidTriangle() }
        .count().toString()

    override fun calculateAdvanced(): String = input.map(String::toListOfInts).switchRowsToColumns()
        .filter { it.isValidTriangle() }
        .count().toString()

    private fun List<Int>.isValidTriangle() =
        valid(this[0], this[1], this[2])
            && valid(this[0], this[2], this[1])
            && valid(this[1], this[2], this[0])

    private fun valid(side1: Int, side2: Int, side3: Int) = side1 + side2 > side3

    private fun List<List<Int>>.switchRowsToColumns(): List<List<Int>> {
        val flatList = mutableListOf<Int>()
        flatList.addAll(this.map { it[0] })
        flatList.addAll(this.map { it[1] })
        flatList.addAll(this.map { it[2] })

        return (0..(flatList.size - 1) step 3).map { listOf(flatList[it], flatList[it + 1], flatList[it + 2]) }
    }
}
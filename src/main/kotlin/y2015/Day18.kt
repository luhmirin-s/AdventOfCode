package y2015

import core.AbstractDay

class Day18(input: List<String>) : AbstractDay(input) {

    private val SIZE = 100

    private val SECOND_ROW_THRESHOLD = SIZE
    private val LAST_ROW_THRESHOLD = SIZE * SIZE - SIZE

    private val FIRST_COLUMN_THRESHOLD = 0
    private val LAST_COLUMN_THRESHOLD = SIZE - 1

    private val CORNER_1 = 0
    private val CORNER_2 = SIZE - 1
    private val CORNER_3 = SIZE * SIZE - SIZE
    private val CORNER_4 = SIZE * SIZE - 1

    override fun calculate(): String = input.toBooleanList()
        .iterateSteps(100, false)
        .count { it }
        .toString()

    override fun calculateAdvanced(): String = input.toBooleanList()
        .iterateSteps(100, true)
        .count { it }
        .toString()


    private fun List<String>.toBooleanList()
        = this.joinToString(separator = "").toCharArray().map { it == '#' }

    private fun List<Boolean>.iterateSteps(steps: Int, advanced: Boolean): List<Boolean> {
        var currentStep = this.lightCorners(advanced)
        for (i in 0 until steps) currentStep = currentStep.computeStep().lightCorners(advanced)
        return currentStep
    }

    private fun List<Boolean>.computeStep() = this.mapIndexed { index, isCellOn ->
        val neighbours = this.countNeighbours(index)
        return@mapIndexed if (neighbours == 3) true else isCellOn && neighbours == 2
    }

    private fun List<Boolean>.lightCorners(advanced: Boolean): List<Boolean> {
        if (!advanced) return this

        val list = this.toMutableList()
        list[CORNER_1] = true
        list[CORNER_2] = true
        list[CORNER_3] = true
        list[CORNER_4] = true
        return list
    }

    private fun List<Boolean>.countNeighbours(index: Int): Int {
        val firstColumn = (index % SIZE) == FIRST_COLUMN_THRESHOLD
        val lastColumn = (index % SIZE) == LAST_COLUMN_THRESHOLD
        var result = 0

        if (index >= SECOND_ROW_THRESHOLD) {
            if (!firstColumn && this[index - SIZE - 1]) result++
            if (this[index - SIZE]) result++
            if (!lastColumn && this[index - SIZE + 1]) result++
        }

        if (index < LAST_ROW_THRESHOLD) {
            if (!firstColumn && this[index + SIZE - 1]) result++
            if (this[index + SIZE]) result++
            if (!lastColumn && this[index + SIZE + 1]) result++
        }

        if (!firstColumn && this[index - 1]) result++
        if (!lastColumn && this[index + 1]) result++

        return result
    }

}
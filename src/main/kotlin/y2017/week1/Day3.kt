package y2017.week1

import core.AbstractDay
import kotlin.math.absoluteValue

class Day3(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine.toInt()
        .let { num ->
            getCellForCheck(
                valueCheck = { it == num },
                nextValueCallback = { _, c -> c.v + 1 }
            )
        }
        .let { it.x.absoluteValue + it.y.absoluteValue }
        .toString()

    override fun calculateAdvanced(): String = inputFirstLine.toInt()
        .let { num ->
            getCellForCheck(
                valueCheck = { it > num },
                nextValueCallback = { cells, c -> cells.getSumOfNeighbours(c.x, c.y) }
            )
        }.v.toString()


    private data class Cell(val x: Int, val y: Int, val v: Int)

    private enum class Direction(val dx: Int, val dy: Int) {
        LEFT(1, 0),
        UP(0, 1),
        RIGHT(-1, 0),
        DOWN(0, -1)
    }

    private inline fun getCellForCheck(
        crossinline valueCheck: (Int) -> Boolean,
        crossinline nextValueCallback: (List<Cell>, Cell) -> Int
    ): Cell {
        val cells = mutableListOf<Cell>()
        var x = 0
        var y = 0
        var v = 1
        var direction = Direction.LEFT

        for (i in 0..300000) {
            val newCell = Cell(x, y, v)
            cells.add(newCell)

            if (valueCheck(v)) return newCell

            x += direction.dx
            y += direction.dy
            v = nextValueCallback(cells, Cell(x, y, v))

            when (direction) {
                Direction.LEFT -> cells.getCellAt(x, y + 1) ?: run { direction = Direction.UP }
                Direction.UP -> cells.getCellAt(x - 1, y) ?: run { direction = Direction.RIGHT }
                Direction.RIGHT -> cells.getCellAt(x, y - 1) ?: run { direction = Direction.DOWN }
                Direction.DOWN -> cells.getCellAt(x + 1, y) ?: run { direction = Direction.LEFT }
            }
        }

        throw RuntimeException("range too small")
    }

    private fun List<Cell>.getSumOfNeighbours(x: Int, y: Int): Int = listOfNotNull(
        getCellAt(x, y + 1),
        getCellAt(x, y - 1),
        getCellAt(x + 1, y + 1),
        getCellAt(x + 1, y),
        getCellAt(x + 1, y - 1),
        getCellAt(x - 1, y + 1),
        getCellAt(x - 1, y),
        getCellAt(x - 1, y - 1)
    ).map { it.v }.sum()

    private fun List<Cell>.getCellAt(x: Int, y: Int) = firstOrNull { it.x == x && it.y == y }

}

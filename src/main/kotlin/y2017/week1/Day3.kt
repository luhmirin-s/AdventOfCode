package y2017.week1

import core.AbstractDay
import kotlin.math.absoluteValue

private typealias Point = Pair<Int, Int>
private typealias Cell = Pair<Point, Int>
private typealias Cells = Map<Point, Int>

class Day3(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine.toInt()
        .let { getCells(it) { _, _, v -> v + 1 } }
        .let { it.first.first.absoluteValue + it.first.second.absoluteValue }
        .toString()

    override fun calculateAdvanced(): String = inputFirstLine.toInt()
        .let { getCells(it) { cells, c, _ -> cells.getSumOfNeighbours(c.first, c.second) } }
        .second
        .toString()

    private enum class Direction(val dx: Int, val dy: Int) {
        LEFT(1, 0),
        UP(0, 1),
        RIGHT(-1, 0),
        DOWN(0, -1)
    }

    private inline fun getCells(
        maxValue: Int,
        crossinline nextValueCallback: (Cells, Point, Int) -> Int
    ): Cell {
        val cells = mutableMapOf<Point, Int>()
        var x = 0
        var y = 0
        var v = 1
        var direction = Direction.LEFT

        for (i in 0..300000) {
            cells.put(x to y, v)

            if (v >= maxValue) return ((x to y) to v)

            x += direction.dx
            y += direction.dy
            v = nextValueCallback(cells, x to y, v)

            when (direction) {
                Direction.LEFT -> cells.getCellValueAt(x, y + 1) ?: run { direction = Direction.UP }
                Direction.UP -> cells.getCellValueAt(x - 1, y) ?: run { direction = Direction.RIGHT }
                Direction.RIGHT -> cells.getCellValueAt(x, y - 1) ?: run { direction = Direction.DOWN }
                Direction.DOWN -> cells.getCellValueAt(x + 1, y) ?: run { direction = Direction.LEFT }
            }
        }

        throw RuntimeException("range too small")
    }

    private fun Cells.getSumOfNeighbours(x: Int, y: Int): Int = listOfNotNull(
        getCellValueAt(x, y + 1),
        getCellValueAt(x, y - 1),
        getCellValueAt(x + 1, y + 1),
        getCellValueAt(x + 1, y),
        getCellValueAt(x + 1, y - 1),
        getCellValueAt(x - 1, y + 1),
        getCellValueAt(x - 1, y),
        getCellValueAt(x - 1, y - 1)
    ).map { it }.sum()

    private fun Cells.getCellValueAt(x: Int, y: Int) = get(x to y)

}

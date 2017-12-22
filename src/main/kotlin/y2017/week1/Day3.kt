package y2017.week1

import core.AbstractDay
import core.extensions.Direction
import core.extensions.Vector2

private typealias Cell = Pair<Vector2, Int>
private typealias Cells = Map<Vector2, Int>

class Day3(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine.toInt()
        .let { getCells(it) { _, _, v -> v + 1 } }
        .first
        .manhattanDistance
        .toString()

    override fun calculateAdvanced(): String = inputFirstLine.toInt()
        .let { getCells(it) { cells, c, _ -> cells.getSumOfNeighbours(c) } }
        .second
        .toString()

    private inline fun getCells(
        maxValue: Int,
        crossinline nextValueCallback: (Cells, Vector2, Int) -> Int
    ): Cell {
        val cells = mutableMapOf<Vector2, Int>()

        var c = Vector2(0, 0)
        var v = 1
        var direction = Direction.RIGHT

        for (i in 0..300000) {
            cells.put(c, v)

            if (v >= maxValue) return (c to v)

            c += direction
            v = nextValueCallback(cells, c, v)

            if (cells[c + direction.turnLeft()] == null) {
                direction = direction.turnLeft()
            }
        }

        throw RuntimeException("range too small")
    }

    private fun Cells.getSumOfNeighbours(c: Vector2): Int = c.neighbours.mapNotNull { get(it) }.sum()


}

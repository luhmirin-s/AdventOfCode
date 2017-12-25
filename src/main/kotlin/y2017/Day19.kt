package y2017

import core.AbstractDay
import core.extensions.Direction
import core.extensions.Direction.*
import core.extensions.Vector2
import core.extensions.joinWithoutSpaces
import core.extensions.toCharList

class Day19(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input
        .map { it.toCharList() }
        .let { field -> mutableListOf<Char>().also { runAround(field, it) } }
        .joinWithoutSpaces()

    override fun calculateAdvanced() = input
        .map { it.toCharList() }
        .let { runAround(it, mutableListOf()) }
        .toString()

    private fun runAround(field: List<List<Char>>, letters: MutableList<Char>): Int {
        var steps = 1
        var direction = DOWN
        var pos = Vector2(field[0].indexOf('|'), 0)
        while (true) {
            // Using only bottom left quadrant, so all vectors are subtracted instead
            pos -= direction

            val c = field[pos.y][pos.x]
            when (c) {
                ' ' -> return steps
                '+' -> direction = direction.changeDirection(pos, field)
                '-', '|' -> {
                }
                else -> letters.add(c)
            }
            steps++
        }
    }

    private fun Direction.changeDirection(point: Vector2, field: List<List<Char>>): Direction = when (this) {
        RIGHT, LEFT -> when {
            field[point.y - 1][point.x] != ' ' -> UP
            else -> DOWN
        }
        UP, DOWN -> when {
            field[point.y][point.x - 1] != ' ' -> RIGHT
            else -> LEFT
        }
    }

}
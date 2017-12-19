package y2017.week4

import core.AbstractDay
import core.extensions.Direction
import core.extensions.Direction.*
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
        var pos = Point(field[0].indexOf('|'), 0)
        while (true) {
            pos += direction

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

    private data class Point(val x: Int, val y: Int) {
        // Because field is some looney upside down land :)
        operator fun plus(d: Direction) = Point(x - d.dx, y - d.dy)
    }

    private fun Direction.changeDirection(point: Point, field: List<List<Char>>): Direction = when (this) {
        LEFT, RIGHT -> when {
            field[point.y - 1][point.x] != ' ' -> UP
            else -> DOWN
        }
        UP, DOWN -> when {
            field[point.y][point.x - 1] != ' ' -> LEFT
            else -> RIGHT
        }
    }

}
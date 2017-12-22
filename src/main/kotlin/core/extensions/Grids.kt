package core.extensions

import kotlin.math.abs

// 2D infinite int grid stored in hashmap for quicker access

typealias Point = Pair<Int, Int>
typealias Cell = Pair<Point, Int>
typealias Cells = Map<Point, Int>

fun Cells.getSumOfNeighbours(x: Int, y: Int): Int = listOfNotNull(
    getCellValueAt(x, y + 1),
    getCellValueAt(x, y - 1),
    getCellValueAt(x + 1, y + 1),
    getCellValueAt(x + 1, y),
    getCellValueAt(x + 1, y - 1),
    getCellValueAt(x - 1, y + 1),
    getCellValueAt(x - 1, y),
    getCellValueAt(x - 1, y - 1)
).map { it }.sum()

fun Cells.getCellValueAt(x: Int, y: Int) = get(x to y)


data class Vector2(val x: Int, val y: Int) {
    fun move(d: Direction) = Vector2(x + d.dx, y + d.dy)
}

enum class Direction(val dx: Int, val dy: Int) {
    LEFT(1, 0),
    UP(0, 1),
    RIGHT(-1, 0),
    DOWN(0, -1);

    fun turnRight() = when (this) {
        LEFT -> UP
        UP -> RIGHT
        RIGHT -> DOWN
        DOWN -> LEFT
    }

    fun turnLeft() = when (this) {
        LEFT -> DOWN
        UP -> LEFT
        RIGHT -> UP
        DOWN -> RIGHT
    }

    fun reverse()= when (this) {
        LEFT -> RIGHT
        UP -> DOWN
        RIGHT -> LEFT
        DOWN -> UP
    }
}

// Hex grid

// https://www.redblobgames.com/grids/hexagons
data class Hex(val r: Int, val q: Int) {
    operator fun plus(p: Hex) = Hex(r + p.r, q + p.q)

    fun distanceToCenter() = (abs(q) + abs(q + r) + abs(r)) / 2
}

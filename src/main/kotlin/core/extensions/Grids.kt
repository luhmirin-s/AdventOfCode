package core.extensions

import kotlin.math.abs
import kotlin.math.absoluteValue


data class Vector2(val x: Int, val y: Int) {

    val manhattanDistance get() = x.absoluteValue + y.absoluteValue

    val orthogonalNeighbours
        get() = listOf(
            Vector2(x - 1, y),
            Vector2(x + 1, y),
            Vector2(x, y - 1),
            Vector2(x, y + 1)
        )

    val neighbours
        get() = listOf(
            Vector2(x - 1, y + 1),
            Vector2(x - 1, y),
            Vector2(x - 1, y - 1),
            Vector2(x, y + 1),
            Vector2(x, y - 1),
            Vector2(x + 1, y + 1),
            Vector2(x + 1, y),
            Vector2(x + 1, y - 1)
        )

    operator fun plus(v: Direction) = Vector2(x + v.dx, y + v.dy)
    operator fun plus(v: Vector2) = Vector2(x + v.x, y + v.y)

    operator fun minus(v: Direction) = Vector2(x - v.dx, y - v.dy)
    operator fun minus(v: Vector2) = Vector2(x - v.x, y - v.y)
}

enum class Direction(val dx: Int, val dy: Int) {
    RIGHT(1, 0),
    UP(0, 1),
    LEFT(-1, 0),
    DOWN(0, -1);

    fun turnRight() = when (this) {
        RIGHT -> UP
        UP -> LEFT
        LEFT -> DOWN
        DOWN -> RIGHT
    }

    fun turnLeft() = when (this) {
        RIGHT -> DOWN
        UP -> RIGHT
        LEFT -> UP
        DOWN -> LEFT
    }

    fun reverse() = when (this) {
        RIGHT -> LEFT
        UP -> DOWN
        LEFT -> RIGHT
        DOWN -> UP
    }
}

//  3D grid

data class Vector3(val x: Int, val y: Int, val z: Int) {
    val manhattanDistance get() = x.absoluteValue + y.absoluteValue + z.absoluteValue

    operator fun plus(v: Vector3) = Vector3(x + v.x, y + v.y, z + v.z)
}


// Hex grid

// https://www.redblobgames.com/grids/hexagons
data class Hex(val r: Int, val q: Int) {
    operator fun plus(p: Hex) = Hex(r + p.r, q + p.q)

    fun distanceToCenter() = (abs(q) + abs(q + r) + abs(r)) / 2
}



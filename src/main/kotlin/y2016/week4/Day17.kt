package y2016.week4

import core.AbstractDay
import core.extensions.md5Hex

class Day17(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val salt = inputFirstLine

        return Room(salt, 0, 0).getPossiblePaths()
            .sortedBy { it.length }
            .first()
            .removePrefix(salt)
    }


    override fun calculateAdvanced(): String {
        val salt = inputFirstLine

        return Room(salt, 0, 0).getPossiblePaths()
            .sortedBy { it.length }
            .last()
            .removePrefix(salt)
            .length.toString()
    }


    //This represent 4 directions up, odwn, left, right
    private val dx = intArrayOf(0, 0, -1, 1)
    private val dy = intArrayOf(-1, 1, 0, 0)

    private fun Room.getPossiblePaths(): List<String> {
        val result = mutableListOf<String>()
        val path = mutableListOf(this)

        while (!path.isEmpty() && path.size < 10000) {
            val currentPoint = path.removeAt(0)
            val openDirections = currentPoint.getOpenDirections()

            for (direction in 0..3) {
                val newPoint = currentPoint.getNeighbour(direction)

                if (!newPoint.isWall() && openDirections[direction]) {
                    if (newPoint.x == 3 && newPoint.y == 3) {
                        result.add(newPoint.path)
                    } else {
                        path.add(newPoint)
                    }
                }
            }
        }
        return result
    }

    private data class Room(val path: String, val x: Int, val y: Int)

    private fun Room.getNeighbour(direction: Int) = Room(
        this.path + when (direction) {
            0 -> 'U'
            1 -> 'D'
            2 -> 'L'
            else -> 'R'
        },
        this.x + dx[direction],
        this.y + dy[direction]
    )

    private fun Room.isWall() = this.x < 0 || this.y < 0 || this.x > 3 || this.y > 3

    private fun Room.getOpenDirections() = this.path.md5Hex().substring(0..3).toCharArray().map {
        when (it) {
            in 'b'..'f' -> true
            else -> false
        }
    }
}
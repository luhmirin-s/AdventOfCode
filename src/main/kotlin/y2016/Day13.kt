package y2016

import core.AbstractDay
import core.extensions.isOdd


class Day13(input: List<String>) : AbstractDay(input) {

    private val MAX_SIZE = 1000

    override fun calculate(): String {
        val salt = inputFirstLine.toInt()
        return Point(1, 1, salt).findAllAchievablePoints()[Point(31, 39, salt)].toString()
    }

    override fun calculateAdvanced(): String {
        val salt = inputFirstLine.toInt()
        return Point(1, 1, salt)
            .findAllAchievablePoints()
            .filterValues { it <= 50 }
            .count().toString()
    }

    private data class Point(val x: Int, val y: Int, val salt: Int)

    private fun Point.isWall(): Boolean {
        return this.x < 0 || this.y < 0
            || ((x * x) + (3 * x) + (2 * x * y) + y + (y * y) + salt).toString(2)
            .toCharArray().filter { it == '1' }.count().isOdd()
    }

    //This represent 4 directions right, left, down , up
    private val dx = intArrayOf(0, 0, 1, -1)
    private val dy = intArrayOf(1, -1, 0, 0)

    private fun Point.getNeighbour(direction: Int) = Point(this.x + dx[direction], this.y + dy[direction], this.salt)

    private fun Point.findAllAchievablePoints(): Map<Point, Int> {
        val visited = mutableMapOf<Point, Int>(this to 0)
        val path = mutableListOf(this)

        while (!path.isEmpty() && path.size < MAX_SIZE) {
            val currentPoint = path.removeAt(0)

            for (direction in 0..3) {
                val newPoint = currentPoint.getNeighbour(direction)

                if (!newPoint.isWall() && !visited.containsKey(newPoint)) {
                    visited[newPoint] = 1 + visited[currentPoint]!!
                    path.add(newPoint)
                }
            }
        }
        return visited
    }
}

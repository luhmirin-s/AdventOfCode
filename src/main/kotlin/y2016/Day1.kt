package y2016

import core.AbstractDay
import core.extensions.collect

class Day1(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine.split(", ")
        .map { it.toStep() }
        .collect(Position(0, Point(0, 0)), Position::move)
        .currentPoint.getDistanceToZero().toString()

    override fun calculateAdvanced(): String = inputFirstLine.split(", ")
        .map { it.toStep() }
        .collect(Position(0, Point(0, 0)), Position::move)
        .firstCrossPoint?.getDistanceToZero().toString()

    private data class Step(val direction: Char, val distance: Int)

    private fun String.toStep(): Step = Step(this[0], this.substring(1).toInt())

    private data class Point(val x: Int, val y: Int) {
        fun getDistanceToZero() = Math.abs(x) + Math.abs(y)
    }

    private class Position(var direction: Int, var currentPoint: Point) {

        var firstCrossPoint: Point? = null
        private val pointsHistory = mutableSetOf<Point>()

        fun move(step: Step) {
            direction = when (step.direction) {
                'R' -> (direction + 1) % 4
                else -> (direction + 3) % 4 // L
            }

            val newPoint = when (direction) {
                0 -> getNewPointWithHistory(step) { Point(currentPoint.x, currentPoint.y + it) }      // 0 - North
                2 -> getNewPointWithHistory(step) { Point(currentPoint.x, currentPoint.y - it) }      // 2 - South
                1 -> getNewPointWithHistory(step) { Point(currentPoint.x + it, currentPoint.y) }      // 1 - East
                else -> getNewPointWithHistory(step) { Point(currentPoint.x - it, currentPoint.y) }   // 3 - West
            }
            currentPoint = newPoint
        }

        private fun getNewPointWithHistory(step: Step, pointProvider: (Int) -> Point): Point {
            if (firstCrossPoint == null) {
                recordHistory(step, pointProvider)
            }
            return pointProvider(step.distance)
        }

        private fun recordHistory(step: Step, getPoint: (Int) -> Point) {
            for (i in 0..(step.distance - 1)) {
                val newPoint = getPoint(i)
                if (!pointsHistory.add(newPoint)) {
                    firstCrossPoint = newPoint
                    break
                }
            }
        }
    }
}
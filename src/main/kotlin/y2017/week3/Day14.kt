package y2017.week3

import core.AbstractDay
import core.extensions.Vector2
import core.extensions.toCharList
import y2017.KnotHash

class Day14(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine
        .transformToGrid()
        .map { it.filter { it }.count() }
        .sum()
        .toString()

    override fun calculateAdvanced(): String {
        val regions = mutableListOf<Set<Vector2>>()

        val usedPoints = inputFirstLine.transformToGrid()
            .mapIndexed { y, row ->
                row.mapIndexedNotNull { x, used -> if (used) Vector2(x, y) else null }
            }
            .flatMap { it }

        usedPoints.forEach { point ->
            if (regions.none { it.contains(point) }) {
                val newRegion = mutableSetOf<Vector2>()
                point.getAllConnected(usedPoints, newRegion)
                regions.add(newRegion)
            }
        }
        return regions.size.toString()
    }

    private fun String.transformToGrid() = List(128) { "$this-$it" }
        .map { it.toCharList().map { it.toInt() } }
        .map { KnotHash().hash(it) }
        .map { it.hexStringToListOfBinary() }

    private fun String.hexStringToListOfBinary() = chunked(1)
        .map { it.toInt(16).toString(2).padStart(4, '0') }
        .flatMap { it.toCharList().map { it == '1' } }

    private fun Vector2.getAllConnected(points: List<Vector2>, region: MutableSet<Vector2>) {
        region.add(this)
        orthogonalNeighbours.forEach {
            if (!region.contains(it) && points.contains(it)) it.getAllConnected(points, region)
        }
    }
}
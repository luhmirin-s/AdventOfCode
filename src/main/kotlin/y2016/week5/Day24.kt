package y2016.week5

import core.AbstractDay
import core.extensions.permutations

class Day24(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val field = input.parse()
        val positions = field.findPlacesToVisit()
        val filteredDistances = getDistanceMap(field, positions)

        return filteredDistances.keys.filter { it != 0 }.toSet().permutations().map {
            val actualPath = it.toMutableList()
            actualPath.add(0, 0)
            actualPath
        }.computeDistance(filteredDistances).min().toString()
    }

    override fun calculateAdvanced(): String {
        val field = input.parse()
        val positions = field.findPlacesToVisit()
        val filteredDistances = getDistanceMap(field, positions)

        return filteredDistances.keys.filter { it != 0 }.toSet().permutations().map {
            val actualPath = it.toMutableList()
            actualPath.add(0, 0)
            actualPath.add(0)
            actualPath
        }.computeDistance(filteredDistances).min().toString()
    }


    private fun Char.toNumber() = this.toInt() - 48

    private data class Place(val x: Int, val y: Int, val value: Char)

    private fun List<String>.parse() = this
        .mapIndexed { y, str -> str.toCharArray().mapIndexed { x, c -> Place(x, y, c) } }

    private fun List<List<Place>>.findPlacesToVisit() = this.flatMap { it }
        .filter { it.value != '#' && it.value != '.' }
        .map { it.value.toNumber() to it }.toMap()


    //This represent 4 directions right, left, down , up
    private val dx = intArrayOf(0, 0, 1, -1)
    private val dy = intArrayOf(1, -1, 0, 0)

    private fun Place.isWall() = this.value == '#'

    private fun Place.getNeighbour(direction: Int, field: List<List<Place>>) =
        field[this.y + dy[direction]][this.x + dx[direction]]

    private fun getDistanceMap(field: List<List<Place>>, positions: Map<Int, Place>): Map<Int, Map<Int, Int>> {
        val distances = mutableMapOf<Place, MutableMap<Place, Int>>()
        for ((_, value) in positions) distances.put(value, getDistances(value, field, positions))

        return distances
            .map { it.key.value.toNumber() to it.value.map { it.key.value.toNumber() to it.value }.toMap() }
            .toMap()
    }

    private fun getDistances(start: Place, field: List<List<Place>>, positions: Map<Int, Place>): MutableMap<Place, Int> {
        val visited = mutableMapOf(start to 0)
        val path = mutableListOf(start)

        val searchablePlaces = positions.values
        val result = mutableMapOf<Place, Int>()

        while (!path.isEmpty() && path.size < 10000) {
            val currentPoint = path.removeAt(0)

            for (direction in 0..3) {
                val newPoint = currentPoint.getNeighbour(direction, field)

                if (!newPoint.isWall() && !visited.containsKey(newPoint)) {
                    visited[newPoint] = 1 + visited[currentPoint]!!
                    path.add(newPoint)
                    if (searchablePlaces.contains(newPoint)) {
                        result.put(newPoint, visited[newPoint]!!)
                    }
                }
            }
        }
        return result
    }

    private fun List<List<Int>>.computeDistance(filteredDistances: Map<Int, Map<Int, Int>>): List<Int> {
        return this.map { path ->
            val distance = (0..path.size - 2).sumBy { filteredDistances[path[it]]!![path[it + 1]]!! }
            distance
        }
    }

}
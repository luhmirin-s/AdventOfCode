package y2015.week2

import core.AbstractDay
import core.extensions.permutations
import java.util.*

class Day9(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val towns: MutableSet<String> = HashSet()
        val routes: MutableList<Route> = ArrayList()

        fillCollections(routes, towns)

        return towns.permutations()
            .map { it.toDistances(routes).sum() }
            .min()
            .toString()
    }


    override fun calculateAdvanced(): String {
        val towns: MutableSet<String> = HashSet()
        val routes: MutableList<Route> = ArrayList()

        fillCollections(routes, towns)

        return towns.permutations()
            .map { it.toDistances(routes).sum() }
            .max()
            .toString()
    }


    private data class Route(val start: String, val end: String, val distance: Int)

    private fun fillCollections(routes: MutableList<Route>, towns: MutableSet<String>) {
        input.forEach {
            val tokens = it.split(" ")
            val fromTown = tokens[0]
            val toTown = tokens[2]
            val dist = tokens[4].toInt()

            towns.add(fromTown)
            towns.add(toTown)

            routes.add(Route(fromTown, toTown, dist))
            routes.add(Route(toTown, fromTown, dist))
        }
    }

    private fun List<String>.toDistances(routes: MutableList<Route>): List<Int> {
        return this.mapIndexed { i, _ ->
            var res = 0
            if (i < this.size - 1)
                res = routes.find { r -> r.start == this[i] && r.end == this[i + 1] }?.distance ?: 0
            return@mapIndexed res
        }
    }
}
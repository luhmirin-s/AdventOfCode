package days.week2

import core.AbstractDay
import core.extensions.permutations
import java.util.*

class Day9 : AbstractDay("day_9") {

    override fun calculate(): String {
        var towns: MutableSet<String> = HashSet()
        var routes: MutableList<Route> = ArrayList()

        fillCollections(routes, towns)

        return towns.permutations()
                .map { it.toDistances(routes).sum() }
                .min()
                .toString()
    }


    override fun calculateAdvanced(): String {
        var towns: MutableSet<String> = HashSet()
        var routes: MutableList<Route> = ArrayList()

        fillCollections(routes, towns)

        return towns.permutations()
                .map { it.toDistances(routes).sum() }
                .max()
                .toString()
    }


    private data class Route(val start: String, val end: String, val distance: Int)

    private fun fillCollections(routes: MutableList<Route>, towns: MutableSet<String>) {
        input().forEach {
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
        return this.mapIndexed { i, str ->
            var res = 0
            if (i < this.size - 1)
                res = routes.find { r -> r.start.equals(this[i]) && r.end.equals(this[i + 1]) }?.distance ?: 0
            return@mapIndexed res
        }
    }
}
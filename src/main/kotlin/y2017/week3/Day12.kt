package y2017.week3

import core.AbstractDay
import core.extensions.getInt
import core.extensions.getString
import core.extensions.mapToPattern

private typealias Connections = Map<Int, List<Int>>

class Day12(input: List<String>) : AbstractDay(input) {

    override fun calculate() = input.parseConnections()
        .toConnectedGroups()
        .first { it.contains(0) }
        .size
        .toString()

    override fun calculateAdvanced() = input.parseConnections()
        .toConnectedGroups()
        .size
        .toString()

    //language=RegExp
    private fun List<String>.parseConnections() = mapToPattern("(\\d*)\\s<->\\s(.*)") {
        it.getInt(1) to it.getString(2).split(", ").map { it.toInt() }
    }.toMap()

    private fun Connections.toConnectedGroups(): List<Set<Int>> = mutableListOf<MutableSet<Int>>().also { groups ->
        keys.forEach { key ->
            if (groups.none { it.contains(key) }) {
                mutableSetOf<Int>()
                    .also { key.visitAllConnected(this, it) }
                    .let { groups.add(it) }
            }
        }
    }

    private fun Int.visitAllConnected(connections: Connections, visited: MutableSet<Int>) {
        visited.add(this)
        connections[this]
            ?.filterNot { visited.contains(it) }
            ?.forEach { it.visitAllConnected(connections, visited) }
    }

}

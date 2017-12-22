package y2017.week5

import core.AbstractDay
import core.extensions.Direction
import core.extensions.Vector2


class Day22(input: List<String>) : AbstractDay(input) {

    override fun calculate() = input.getNotCleanNodes()
        .toMutableMap()
        .let { nodes ->
            (0 until 10_000).fold(Virus()) { v, _ -> v.burst1(nodes) }
        }
        .infectsCaused
        .toString()

    override fun calculateAdvanced() = input.getNotCleanNodes()
        .toMutableMap()
        .let { nodes ->
            (0 until 10_000_000).fold(Virus()) { v, _ -> v.burst2(nodes) }
        }
        .infectsCaused
        .toString()

    private fun List<String>.getNotCleanNodes() = let { (it.size / 2) }
        .let {
            mapIndexed { y, line ->
                line.mapIndexed { x, ch -> Pair(Vector2(x - it, it - y), ch) }
            }
        }
        .flatMap { it }
        .filter { it.second != '.' }
        .toMap()

    private data class Virus(
        var direction: Direction = Direction.UP,
        var pos: Vector2 = Vector2(0, 0),
        var infectsCaused: Int = 0
    )

    private fun Virus.burst1(infected: MutableMap<Vector2, Char>) = apply {
        if (infected.containsKey(pos)) {
            direction = direction.turnLeft()
            infected.remove(pos)
        } else {
            direction = direction.turnRight()
            infected.put(pos, '#')
            infectsCaused++
        }
        pos = pos.move(direction)
    }

    private fun Virus.burst2(infected: MutableMap<Vector2, Char>) = apply {
        when (infected[pos]) {
            null -> { //clean
                direction = direction.turnRight()
                infected.put(pos, 'W')
            }
            'W' -> {
                infected.put(pos, '#')
                infectsCaused++
            }
            '#' -> {
                direction = direction.turnLeft()
                infected.put(pos, 'F')
            }
            'F' -> {
                direction = direction.reverse()
                infected.remove(pos)
            }
        }
        pos = pos.move(direction)
    }
}

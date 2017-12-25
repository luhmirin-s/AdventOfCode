package y2015


import core.AbstractDay
import core.extensions.isOdd
import java.util.*

class Day3(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        var position = Coord(0, 0)
        val visitedHomes = HashSet<Coord>()

        visitedHomes.add(position)

        inputFirstLineChars.forEach { c ->
            position = position.move(c)
            visitedHomes.add(position)
        }

        return visitedHomes.size.toString()
    }

    override fun calculateAdvanced(): String {
        var santaPosition = Coord(0, 0)
        var roboSantaPosition = Coord(0, 0)

        val visitedHomes = HashSet<Coord>()

        visitedHomes.add(santaPosition)
        visitedHomes.add(roboSantaPosition)

        inputFirstLineChars.forEachIndexed { i, c ->
            if (i.isOdd()) {
                santaPosition = santaPosition.move(c)
                visitedHomes.add(santaPosition)
            } else {
                roboSantaPosition = roboSantaPosition.move(c)
                visitedHomes.add(roboSantaPosition)
            }
        }
        return visitedHomes.size.toString()
    }


    // Utils

    private data class Coord(val x: Int, val y: Int)

    private fun Coord.move(direction: Char): Coord = when (direction) {
        '^' -> Coord(x, y + 1)
        'v' -> Coord(x, y - 1)
        '>' -> Coord(x + 1, y)
        '<' -> Coord(x - 1, y)
        else -> Coord(x, y)
    }
}
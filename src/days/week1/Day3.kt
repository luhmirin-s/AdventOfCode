package days.week1


import core.AbstractDay
import core.extensions.isOdd
import java.util.*

class Day3 : AbstractDay("day_3") {

    override fun calculate(): String {
        var position = Coord(0, 0)
        var visitedHomes = HashSet<Coord>()

        visitedHomes.add(position)

        inputFirstLineChars().forEach { c ->
            position = position.move(c)
            visitedHomes.add(position)
        }

        return visitedHomes.size.toString()
    }

    override fun calculateAdvanced(): String {
        var santaPosition = Coord(0, 0)
        var roboSantaPosition = Coord(0, 0)

        var visitedHomes = HashSet<Coord>()

        visitedHomes.add(santaPosition)
        visitedHomes.add(roboSantaPosition)

        inputFirstLineChars().forEachIndexed { i, c ->
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

    data class Coord(val x: Int, val y: Int)

    fun Coord.move(direction: Char): Coord {
        when (direction) {
            '^' -> return Coord(this.x, this.y + 1)
            'v' -> return Coord(this.x, this.y - 1)
            '>' -> return Coord(this.x + 1, this.y)
            '<' -> return Coord(this.x - 1, this.y)
            else -> return Coord(this.x, this.y)
        }
    }
}
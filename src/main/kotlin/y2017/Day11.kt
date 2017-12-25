package y2017

import core.AbstractDay
import core.extensions.Hex


class Day11(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = inputFirstLine
        .mapToSteps()
        .fold(Hex(0, 0)) { r, l -> l + r }
        .distanceToCenter()
        .toString()

    override fun calculateAdvanced(): String = inputFirstLine
        .mapToSteps()
        .let {
            var position = Hex(0, 0)
            it.map {
                position += it
                position.distanceToCenter()
            }
        }
        .max()
        .toString()



    private fun String.mapToSteps() = split(",").map {
        when (it) {
            "n" -> Hex(0, -1)
            "nw" -> Hex(-1, 0)
            "ne" -> Hex(1, -1)
            "s" -> Hex(0, 1)
            "sw" -> Hex(-1, 1)
            "se" -> Hex(1, 0)
            else -> Hex(0, 0)
        }
    }

}
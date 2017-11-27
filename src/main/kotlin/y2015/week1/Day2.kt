package y2015.week1

import core.AbstractDay

class Day2(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        return input
            .map { it.asDimension() }
            .sumBy { it.area() }
            .toString()
    }

    override fun calculateAdvanced(): String {
        return input
            .map { it.asDimension() }
            .sumBy { it.ribbonLength() }
            .toString()
    }

    // Utils

    private fun String.asDimension(): Dimensions = this.split("x")
        .map { it.toInt() }
        .let { Dimensions(it[0], it[1], it[2]) }


    private data class Dimensions(val l: Int, val w: Int, val h: Int)

    private fun Dimensions.asList() = listOf(l, w, h)

    private fun Dimensions.area() = Dimensions(l * w, w * h, h * l)
        .let { it.l * 2 + it.w * 2 + it.h * 2 + it.smallestSide() }

    private fun Dimensions.smallestSide() = this.asList().min() ?: 0

    private fun Dimensions.ribbonLength() = this.asList().sorted()
        .subList(0, 2)
        .let { it[0] * 2 + it[1] * 2 + this.ribbonBow() }

    private fun Dimensions.ribbonBow(): Int = l * w * h
}


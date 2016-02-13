package days.week1

import core.AbstractDay

class Day2 : AbstractDay("day_2") {

    override fun calculate(): String {
        return input().map { s -> s.asDimension() }
                .sumBy { d -> d.area() }
                .toString()
    }

    override fun calculateAdvanced(): String {
        return input().map { s -> s.asDimension() }
                .sumBy { d -> d.ribbonLength() }
                .toString()
    }

    // Utils

    private fun String.asDimension(): Dimensions {
        var arr = this.split("x").map { s -> s.toInt() }
        return Dimensions(arr[0], arr[1], arr[2])
    }



    private data class Dimensions(val l: Int, val w: Int, val h: Int)

    private fun Dimensions.asList(): List<Int> {
        return listOf(this.l, this.w, this.h)
    }

    private fun Dimensions.area(): Int {
        val sides = Dimensions(this.l * this.w, this.w * this.h, this.h * this.l)
        return sides.l * 2 + sides.w * 2 + sides.h * 2 + sides.smallestSide()
    }

    private fun Dimensions.smallestSide(): Int {
        return this.asList().min() ?: 0
    }

    private fun Dimensions.ribbonLength(): Int {
        val smallestSides = this.asList().sorted().subList(0, 2)
        return smallestSides[0] * 2 + smallestSides[1] * 2 + this.ribbonBow()
    }

    private fun Dimensions.ribbonBow(): Int {
        return this.l * this.w * this.h
    }
}


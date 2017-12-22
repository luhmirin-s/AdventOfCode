package y2017.week5

import core.AbstractDay
import core.extensions.toCharList
import kotlin.math.round
import kotlin.math.sqrt


private typealias Pixel = List<List<Char>>
private typealias Rule = Pair<Pixel, Pixel>

class Day21(input: List<String>) : AbstractDay(input) {

    private val startingPixel = ".#./..#/###".toPixel()

    override fun calculate() = input.toRules().let { rules ->
        (0 until 5).fold(startingPixel) { p, _ -> p.enhance(rules) }
    }.countOn()

    override fun calculateAdvanced(): String = input.toRules().let { rules ->
        (0 until 18).fold(startingPixel) { p, _ -> p.enhance(rules) }
    }.countOn()

    // Enhancing image

    private fun Pixel.enhance(rules: Map<Pixel, Pixel>) = split()
        .map { rules[it] ?: throw Exception("missing rule") }
        .collect()

    private fun Pixel.split(): List<Pixel> = mutableListOf<Pixel>().also { result ->
        val step = if (this.size % 2 == 0) 2 else 3
        val parts = this.size / step

        for (pxlsRow in 0 until parts) {
            (0 until parts).mapTo(result) { pxlsCol ->
                (0 until step).map {
                    this[(pxlsRow * step + it)].subList(pxlsCol * step, (pxlsCol + 1) * step)
                }
            }
        }
    }

    private fun List<Pixel>.collect(): Pixel = mutableListOf<List<Char>>().also { pixel ->
        val lines = round(sqrt(size.toFloat())).toInt()
        chunked(lines).forEach { pxlRow ->
            (0 until pxlRow[0].size).mapTo(pixel) { i -> pxlRow.flatMap { it[i] } }
        }
    }

    private fun Pixel.countOn() = flatMap { it.filter { it == '#' } }.count().toString()

    // Expanding rules to include all possible rotations and flips of original rule input

    private fun String.toPixel() = split("/").map { it.toCharList() }

    private fun List<String>.toRules() = map { it.split(" => ") }
        .map { it.first().toPixel() to it.last().toPixel() }
        .expandRules()
        .toMap()

    private fun List<Rule>.expandRules() = flatMap { ogRule ->
        ogRule.first.permutations().map { it to ogRule.second }
    }

    private fun Pixel.permutations() = if (this.size == 2) {
        listOf(
            this,
            listOf(this[1], this[0]), // flip along horizontal axis
            this.map { listOf(it[1], it[0]) } // flip along vertical axis
        ).flatMap { it.allRotations2() }
    } else {
        listOf(
            this,
            listOf(this[2], this[1], this[0]), // flip along horizontal axis
            this.map { listOf(it[2], it[1], it[0]) } // flip along vertical axis
        ).flatMap { it.allRotations3() }
    }.toSet()

    private fun Pixel.allRotations2() = mutableSetOf(this).also { result ->
        fun Pixel.rotate() = listOf(
            listOf(this[1][0], this[0][0]),
            listOf(this[1][1], this[0][1])
        )

        rotate().also { result.add(it) } // 90
            .rotate().also { result.add(it) } // 180
            .rotate().also { result.add(it) } // 270
    }

    private fun Pixel.allRotations3() = mutableSetOf(this).also { result ->
        fun Pixel.rotate() =
            listOf(
                listOf(this[2][0], this[1][0], this[0][0]),
                listOf(this[2][1], this[1][1], this[0][1]),
                listOf(this[2][2], this[1][2], this[0][2])
            )

        rotate().also { result.add(it) } // 90
            .rotate().also { result.add(it) } // 180
            .rotate().also { result.add(it) } // 270
    }
}

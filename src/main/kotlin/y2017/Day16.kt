package y2017

import core.AbstractDay
import core.extensions.*

private typealias Dancers = List<Char>

class Day16(input: List<String>) : AbstractDay(input) {

    override fun calculate() = inputFirstLine.split(",")
        .map { it.toMove() }
        .collect(Collector(dancers)) { c, move ->
            c.value = move.perform(c.value)
        }
        .value
        .joinWithoutSpaces()

    override fun calculateAdvanced() = inputFirstLine.split(",")
        .map { it.toMove() }
        .let { list ->
            Collector(dancers).also {
                for (i in 0 until 1_000_000_000) {
                    it.value = list[i % list.size].perform(it.value)
                }
            }
        }
        .value
        .joinWithoutSpaces()

    private val dancers = "abcdefghijklmnop".toCharList()

    private fun String.toMove() = when (this.first()) {
        's' -> Move.Spin(this.substring(1).toInt())
        'x' -> this.substring(1).split("/")
            .map { it.toInt() }
            .let { Move.Exchange(it) }
        'p' -> this.substring(1).split("/")
            .map { it.first() }
            .let { Move.Partner(it) }
        else -> throw RuntimeException("Huston, we have a problem")
    }

    private sealed class Move {

        abstract fun perform(dancers: Dancers): Dancers

        class Spin(val steps: Int) : Move() {
            override fun perform(dancers: Dancers) = (dancers.size - steps)
                .let { dancers.rotate(it) }
        }

        class Exchange(val positions: List<Int>) : Move() {
            override fun perform(dancers: Dancers) = positions
                .let { it.first() to it.last() }
                .let { dancers.swap(it) }
        }

        class Partner(val positions: List<Char>) : Move() {
            override fun perform(dancers: Dancers) = positions
                .map { dancers.indexOf(it) }
                .let { it.first() to it.last() }
                .let { dancers.swap(it) }
        }
    }
}

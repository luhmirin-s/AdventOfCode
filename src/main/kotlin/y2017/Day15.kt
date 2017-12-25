package y2017

import core.AbstractDay

class Day15(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.makeGenerators().let {
        var judgeCounter = 0
        for (i in 0 until 40_000_000) {
            val a = it.first.getNext().firstBits()
            val b = it.second.getNext().firstBits()
            if (a == b) judgeCounter++
        }
        judgeCounter
    }.toString()

    override fun calculateAdvanced() = input.makeGenerators().let {
        var judgeCounter = 0
        for (i in 0 until 5_000_000) {
            val a = it.first.getNextDivisible().firstBits()
            val b = it.second.getNextDivisible().firstBits()
            if (a == b) judgeCounter++
        }
        judgeCounter
    }.toString()


    private data class Generator(val factor: Long, val divider: Long, var value: Long) {
        fun getNext(): Long = ((value * factor) % 2147483647).also { value = it }

        fun getNextDivisible(): Long {
            while (true) {
                val v = getNext()
                if (v % divider == 0L) return v
            }
        }
    }

    private fun List<String>.makeGenerators(): Pair<Generator, Generator> = map { it.split(" ").last().toLong() }
        .let { Generator(16807L, 4, it.first()) to Generator(48271L, 8, it.last()) }

    private fun Long.firstBits(): Long = this.and(0b1111111111111111)
}
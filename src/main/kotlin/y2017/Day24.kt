package y2017

import core.AbstractDay

class Day24(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input
        .parseBridgeParts()
        .getAllBridges()
        .map { it.sumBy { it.sum } }
        .max()
        .toString()

    override fun calculateAdvanced() = input
        .parseBridgeParts()
        .getAllBridges()
        .groupBy { it.size }
        .maxBy { it.key }
        ?.value
        ?.map { it.sumBy { it.sum } }
        ?.max()
        .toString()

    private data class Part(val p1: Int, val p2: Int) {

        val sum: Int get() = p1 + p2

        fun contains(p: Int) = p == p1 || p == p2

        fun reversed() = Part(p2, p1)

        override fun toString() = "$p1/$p2"
    }

    private fun List<String>.parseBridgeParts() = map {
        it.split("/").let { Part(it.first().toInt(), it.last().toInt()) }
    }

    private fun List<Part>.getAllBridges() = mutableSetOf<MutableList<Part>>()
        .also { bridges ->
            filter { it.contains(0) }.forEach {
                val rest = getCopyOfRest(it)
                it.getPossibleBridges(rest, mutableListOf(it), bridges)
            }
        }

    private fun Part.getPossibleBridges(rest: List<Part>, currentBridge: MutableList<Part>, bridges: MutableSet<MutableList<Part>>) {
        bridges.add(currentBridge.getCopy())

        rest.filter { it.contains(p2) }.forEach {
            val newRest = rest.getCopyOfRest(it)
            when (p2) {
                it.p1 -> it.getPossibleBridges(newRest, currentBridge.getCopyAndAdd(it), bridges)
                it.p2 -> it.reversed().let { r ->
                    r.getPossibleBridges(newRest, currentBridge.getCopyAndAdd(r), bridges)
                }
            }
        }
    }

    private fun List<Part>.getCopy() = MutableList(size) { this[it] }

    private fun List<Part>.getCopyAndAdd(part: Part) = getCopy().also { it.add(part) }

    private fun List<Part>.getCopyOfRest(part: Part) = getCopy().also { it.remove(part) }
}

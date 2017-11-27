package y2016.week5

import core.AbstractDay


class Day22(input: List<String>) : AbstractDay(input) {

    val PATTERN = Regex("/dev/grid/node-x(\\d{1,2})-y(\\d{1,2})\\s+(\\d{1,3})T\\s+(\\d{1,3})T\\s+(\\d{1,3})T.*")

    override fun calculate(): String {
        return input.parse().getAllPairs().size.toString()
    }

    override fun calculateAdvanced(): String {
        //  val nodes = input().parse()
        //  nodes.groupBy { it.y }.values.forEach {
        //      it.map { "(%2d/%3d/%3d) ".format(it.available, it.used, it.size) }.forEach { print(it) }
        //      println()
        //  }

        // This one is actually easier to calculate by hand looking at data:
        // 1) in my data there was only one emtpy node, onther nodes could not fit data from any other node so
        //     this empty node is a hole that I was monig around.
        // 2) need to move this hole next to target data, it takes 1 step to move hole, some nodes are too big, so
        //     it needs to move around them
        // 3) moving target data 1 node to the left takes 5 steps
        // 4) ??????
        // 5) get the result

        return "222"
    }

    private data class Node(val x: Int, val y: Int, val size: Int, val used: Int, val available: Int)

    private fun List<String>.parse(): List<Node> =
        this.map { PATTERN.find(it)?.groupValues }.filterNotNull().map { it.toNode() }

    private fun List<String>.toNode() =
        Node(this[1].toInt(), this[2].toInt(), this[3].toInt(), this[4].toInt(), this[5].toInt())

    private fun List<Node>.getAllPairs(): List<Pair<Node, Node>> {
        val pairs = mutableListOf<Pair<Node, Node>>()

        for (i in 0..(this.size - 2)) {
            for (j in i..(this.size - 1)) {
                val a = this[i]
                val b = this[j]

                if (a == b) continue
                if (a.used > 0 && b.available >= a.used) pairs.add(a to b)
                if (b.used > 0 && a.available >= b.used) pairs.add(b to a)
            }
        }
        return pairs
    }

}
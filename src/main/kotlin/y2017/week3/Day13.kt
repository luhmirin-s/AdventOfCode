package y2017.week3

import core.AbstractDay

class Day13(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.mapScanners()
        .let { Packet(0).checkIfPacketGetsCaught(it) }
        .severity
        .toString()

    override fun calculateAdvanced() = input.mapScanners()
        .let { scanners ->
            (0..5000000).forEach {
                val packet = Packet(it).checkIfPacketGetsCaught(scanners)
                if (!packet.caught) return@let packet
            }
            throw RuntimeException("not enough iterations")
        }
        .delay
        .toString()

    private fun Packet.checkIfPacketGetsCaught(scanners: Map<Int, Scanner>): Packet {
        scanners.forEach { position, scanner ->
            if ((delay + position) % scanner.period == 0) {
                caught = true
                severity += (position * scanner.range)
            }
        }
        return this
    }

    private fun List<String>.mapScanners() = this
        .map { it.split(": ").map { it.toInt() } }
        .map { it[0] to Scanner(it[1]) }
        .toMap()

    private data class Scanner(val range: Int, val period: Int = 2 * (range - 1))

    private data class Packet(val delay: Int, var severity: Int = 0, var caught: Boolean = false)

}
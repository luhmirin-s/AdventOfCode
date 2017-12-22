package y2017.week4

import core.AbstractDay
import core.extensions.Vector3
import core.extensions.getInt
import core.extensions.mapToPatternIndexed

class Day20(input: List<String>) : AbstractDay(input) {

    private val LONG_TERM = 500

    override fun calculate(): String = input.parseParticles()
        .also { p -> (0..LONG_TERM).forEach { _ -> p.forEach { it.simulate() } } }
        .sortedBy { it.p.manhattanDistance }
        .first()
        .index
        .toString()

    override fun calculateAdvanced() = input.parseParticles()
        .let {
            var particles = it
            (0..LONG_TERM).forEach { _ ->
                particles = particles.onEach { it.simulate() }.removeCollisions()
            }
            particles.size
        }.toString()

    private fun List<String>.parseParticles(): List<Particle> = mapToPatternIndexed("p=<([0-9\\-]*),([0-9\\-]*),([0-9\\-]*)>,\\sv=<([0-9\\-]*),([0-9\\-]*),([0-9\\-]*)>,\\sa=<([0-9\\-]*),([0-9\\-]*),([0-9\\-]*)>") { i, g ->
        Particle(
            index = i,
            p = Vector3(g.getInt(1), g.getInt(2), g.getInt(3)),
            v = Vector3(g.getInt(4), g.getInt(5), g.getInt(6)),
            a = Vector3(g.getInt(7), g.getInt(8), g.getInt(9))
        )
    }
    private data class Particle(val index: Int, var p: Vector3, var v: Vector3, var a: Vector3) {
        fun simulate() {
            v += a
            p += v
        }
    }

    private fun List<Particle>.removeCollisions() = groupBy { it.p }
        .filter { it.value.size == 1 }
        .flatMap { it.value }
}
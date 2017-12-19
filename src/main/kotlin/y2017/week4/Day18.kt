package y2017.week4

import core.AbstractDay
import core.extensions.print
import java.util.*


private typealias Registry = MutableMap<String, Long>
private typealias Sounds = LinkedList<Long>

class Day18(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val instructions = input.map { Instruction(it.split(" ")) }
        val queue = LinkedList<Long>()
        val program = Program(0,mutableMapOf(), queue, queue)

        return try {
            while (program.validPos(instructions.indices)) {
                program.pos += instructions[program.pos].execute(program, true)
            }
        } catch (e: Exception) {
            program.outQueue.last()
        }.toString()
    }

    override fun calculateAdvanced(): String {
          TODO("this is still failing")

        val instructions = input.map { Instruction(it.split(" ")) }

        val queue0 = LinkedList<Long>()
        val queue1 = LinkedList<Long>()

        val program0 = Program(0,mutableMapOf("p" to 0L), queue1, queue0)
        val program1 = Program(1,mutableMapOf("p" to 1L), queue0, queue1)

        while (program0.validPos(instructions.indices) || program1.validPos(instructions.indices)) {
            val d0 = instructions.getOrNull(program0.pos)?.execute(program0) ?: 0
            val d1 = instructions.getOrNull(program1.pos)?.execute(program1) ?: 0

            program0.pos += d0
            program1.pos += d1

            if (d0 == 0 && d1 == 0) break //deadlock
        }
        return program1.sentCounter.toString()
    }

    data class Program(
        val num:Int,
        val registry: Registry,
        val outQueue: Sounds,
        val inQueue: Sounds,
        var pos: Int = 0,
        var sentCounter: Int = 0
    ) {
        fun validPos(range: IntRange) = pos in range
    }

    private data class Instruction(val cmd: String, val reg: String, val value: String?) {
        constructor(tokens: List<String>) : this(tokens[0], tokens[1], tokens.getOrNull(2))

        fun value(registries: Registry): Long = value?.toLongOrNull() ?: registries.getOrDefault(value, 0)
    }

    private fun Instruction.execute(program: Program, throwOnRcv: Boolean = false): Int {
        when (cmd) {
            "set" -> set(program.registry)
            "add" -> add(program.registry)
            "mul" -> mul(program.registry)
            "mod" -> mod(program.registry)
            "snd" -> snd(program)
            "rcv" -> rcv(program, throwOnRcv)?.let { return it }
            "jgz" -> jgz(program.registry)?.let { return it }
        }
        return 1
    }

    private fun Instruction.snd(program: Program) {
        with(program) {
            outQueue.add(registry.safeGet(reg))
            sentCounter += 1
        }
    }

    private fun Instruction.rcv(program: Program, throwOnRcv: Boolean): Int? {
        program.registry.safeGet(reg).takeIf { it != 0L }?.let {
            if (throwOnRcv) throw Exception()

            program.inQueue.takeIf { it.isNotEmpty() }
                ?.let {
                    program.registry.put(reg, program.inQueue.pop())
                    return 1
                }
                ?: return 0
        } ?: return 0
    }

    private fun Instruction.set(registry: Registry) {
        value(registry).let { registry.put(reg, it) }
    }

    private fun Instruction.add(registry: Registry) {
        registry.safeGet(reg).plus(value(registry)).let { registry.put(reg, it) }
    }

    private fun Instruction.mul(registry: Registry) {
        registry.safeGet(reg).times(value(registry)).let { registry.put(reg, it) }
    }

    private fun Instruction.mod(registry: Registry) {
        registry.safeGet(reg).rem(value(registry)).let { registry.put(reg, it) }
    }

    private fun Instruction.jgz(registry: Registry) = (reg.toLongOrNull() ?: registry.safeGet(reg))
        .takeIf { it > 0L }
        ?.let { value(registry).toInt() }

    private fun Registry.safeGet(char: String) = this.getOrPut(char) { 0 }

}
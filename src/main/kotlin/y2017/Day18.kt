package y2017

import core.AbstractDay
import java.util.*


private typealias Sounds = LinkedList<Long>

class Day18(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val instructions = input.map { Instruction(it.split(" ")) }
        val queue = LinkedList<Long>()
        val program = Program(0, mutableMapOf(), queue, queue)

        return try {
            while (program.validPos(instructions.indices)) {
                program.pos += instructions[program.pos].exec(program, true)
            }
        } catch (e: Exception) {
            program.outQueue.last()
        }.toString()
    }

    override fun calculateAdvanced(): String {
        TODO("this is still failing")

//        val instructions = input.map { Instruction(it.split(" ")) }
//
//        val queue0 = LinkedList<Long>()
//        val queue1 = LinkedList<Long>()
//
//        val program0 = Program(0, mutableMapOf("p" to 0L), queue1, queue0)
//        val program1 = Program(1, mutableMapOf("p" to 1L), queue0, queue1)
//
//        while (program0.validPos(instructions.indices) || program1.validPos(instructions.indices)) {
//            val d0 = instructions.getOrNull(program0.pos)?.exec(program0) ?: 0
//            val d1 = instructions.getOrNull(program1.pos)?.exec(program1) ?: 0
//
//            program0.pos += d0
//            program1.pos += d1
//
//            if (d0 == 0 && d1 == 0) break //deadlock
//        }
//        return program1.sentCounter.toString()
    }

    data class Program(
        val num: Int,
        val registry: Registry,
        val outQueue: Sounds,
        val inQueue: Sounds,
        var pos: Int = 0,
        var sentCounter: Int = 0
    ) {
        fun validPos(range: IntRange) = pos in range
    }


    private fun Instruction.exec(program: Program, throwOnRcv: Boolean = false): Int {
        return execute(program.registry) {
            when (cmd) {
                "snd" -> snd(program)
                "rcv" -> rcv(program, throwOnRcv)
                else -> 0
            }
        }
    }

    private fun Instruction.snd(program: Program): Int {
        with(program) {
            outQueue.add(registry.safeGet(reg))
            sentCounter += 1
        }
        return 1
    }

    private fun Instruction.rcv(program: Program, throwOnRcv: Boolean): Int {
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

}
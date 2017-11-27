package y2015.week5

import core.AbstractDay
import core.extensions.isOdd

class Day23(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val registers = mutableMapOf(
            'a' to 0,
            'b' to 0
        )

        input.map { it.toInstruction() }.executeInstructions(registers)

        return registers['b'].toString()
    }

    override fun calculateAdvanced(): String {
        val registers = mutableMapOf(
            'a' to 1,
            'b' to 0
        )

        input.map { it.toInstruction() }.executeInstructions(registers)

        return registers['b'].toString()
    }

    private fun String.toInstruction(): Instruction = Instruction(tokens = this.split(' '));

    private data class Instruction(var tokens: List<String>)

    private fun Instruction.command(): String = this.tokens[0]
    private fun Instruction.register(): Char = this.tokens[1].toCharArray()[0]
    private fun Instruction.jumpValue(): Int = this.tokens[1].toInt()
    private fun Instruction.conditionJumpValue(): Int = this.tokens[2].toInt()

    private fun MutableMap<Char, Int>.valueOfRegister(instruction: Instruction): Int = this[instruction.register()] ?: 0


    private fun List<Instruction>.executeInstructions(registers: MutableMap<Char, Int>) {
        var instructionIndex = 0
        while (instructionIndex < this.size) {
            val instruction = this[instructionIndex]

            when (instruction.command()) {
                "hlf" -> {
                    instructionIndex++
                    registers[instruction.register()] = registers.valueOfRegister(instruction) / 2
                }
                "tpl" -> {
                    instructionIndex++
                    registers[instruction.register()] = registers.valueOfRegister(instruction) * 3
                }
                "inc" -> {
                    instructionIndex++
                    registers[instruction.register()] = registers.valueOfRegister(instruction) + 1
                }
                "jmp" -> {
                    instructionIndex += instruction.jumpValue()
                }
                "jie" -> {
                    if (registers.valueOfRegister(instruction).isOdd())
                        instructionIndex++
                    else
                        instructionIndex += instruction.conditionJumpValue()
                }
                "jio" -> {
                    if (registers.valueOfRegister(instruction) == 1)
                        instructionIndex += instruction.conditionJumpValue()
                    else
                        instructionIndex++
                }
            }
        }
    }

}
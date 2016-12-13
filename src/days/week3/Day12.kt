package days.week3

import core.AbstractDay

class Day12 : AbstractDay("week3/day_12") {

    override fun calculate(): String {
        return input().map { it.split(" ") }
                .executeInstructions(mutableMapOf('a' to 0, 'b' to 0, 'c' to 0, 'd' to 0))
                .get('a')
                ?.toString() ?: ""
    }

    override fun calculateAdvanced(): String {
        return input().map { it.split(" ") }
                .executeInstructions(mutableMapOf('a' to 0, 'b' to 0, 'c' to 1, 'd' to 0))
                .get('a')
                ?.toString() ?: ""
    }

    private fun List<List<String>>.executeInstructions(registers: MutableMap<Char, Int>): MutableMap<Char, Int> {
        var counter = 0
        while (counter < this.size) {
            val tokens = this[counter]
            when (tokens.command()) {
                "cpy" -> {
                    when (tokens.firstReg()) {
                        in registers.keys -> {
                            registers[tokens.secondReg()] = registers.getOrPut(tokens.firstReg(), { 0 })
                        }
                        else -> {
                            registers[tokens.secondReg()] = tokens.firstValue()
                        }
                    }
                    counter++
                }
                "inc" -> {
                    val value = registers.getOrPut(tokens.firstReg(), { 0 })
                    registers[tokens.firstReg()] = value + 1
                    counter++
                }
                "dec" -> {
                    val value = registers.getOrPut(tokens.firstReg(), { 0 })
                    registers[tokens.firstReg()] = value - 1
                    counter++
                }
                "jnz" -> {
                    val flag = when (tokens.firstReg()) {
                        in registers.keys -> registers[tokens.firstReg()]!!
                        else -> tokens.firstValue()
                    }
                    if (flag == 0) {
                        counter++
                    } else {
                        counter += tokens.secondValue()
                    }
                }
            }
            if (counter < 0) counter = 0
        }
        return registers
    }

    fun List<String>.command() = this[0]
    fun List<String>.firstReg() = this[1][0]
    fun List<String>.firstValue() = this[1].toInt()
    fun List<String>.secondReg() = this[2][0]
    fun List<String>.secondValue() = this[2].toInt()

}
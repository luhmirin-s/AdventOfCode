package y2015.week2

import core.AbstractDay
import java.util.*

class Day7(input: List<String>) : AbstractDay(input) {

    private val RESULT_WIRE = "a"
    private val NEW_INPUT_WIRE = "b"

    override fun calculate() = input.parse().sort().resolve()[RESULT_WIRE].toString()

    override fun calculateAdvanced(): String {
        val commands = input.parse().sort()
        val valueA = commands.resolve().get(RESULT_WIRE)

        val newCommands = commands
            .filter { command -> command.gate != Gate.IN || !command.resultWire.contentEquals(NEW_INPUT_WIRE) }
            .toMutableList()
        newCommands.add(Command(NEW_INPUT_WIRE, arrayOf(valueA.toString()), Gate.IN))

        return newCommands.sort().resolve()[RESULT_WIRE].toString()
    }


    enum class Gate { OR, AND, LSHIFT, RSHIFT, NOT, IN }
    data class Command(val resultWire: String, val inputWires: Array<String>, val gate: Gate)

    fun Command.first() = inputWires[0]

    fun Command.second() = inputWires[1]


    fun Int.not() = xor(0b1111111111111111)

    private fun Int.trimToShort() = this % 0b1111111111111111


    private fun HashMap<String, Int>.getIfNotNumber(key: String): Int = try {
        key.toInt()
    } catch (e: NumberFormatException) {
        this[key] ?: throw RuntimeException("no item in map")
    }

    fun HashMap<String, Int>.containsOrIsNumber(key: String): Boolean {
        try {
            key.toInt()
            return true
        } catch (e: NumberFormatException) {
            return this.containsKey(key)
        }
    }


    fun List<String>.parse(): MutableList<Command> {
        return this.map { str ->
            val inputOtputTokens = str.split(" -> ")

            val resultWire = inputOtputTokens[1]
            val inputTokens = inputOtputTokens[0].split(" ")

            val inputWires: Array<String>
            val gate: Gate

            when (inputTokens.size) {
                2 -> {
                    inputWires = arrayOf(inputTokens[1])
                    gate = Gate.NOT
                }
                3 -> {
                    inputWires = arrayOf(inputTokens[0], inputTokens[2])
                    gate = Gate.valueOf(inputTokens[1])
                }
                else -> {
                    inputWires = arrayOf(inputTokens[0].trim())
                    gate = Gate.IN
                }
            }
            Command(resultWire, inputWires, gate);
        }.toMutableList()
    }

    fun MutableList<Command>.sort(): MutableList<Command> {
        return this.sortedWith(Comparator { first, second ->
            if (first.gate == second.gate)
                return@Comparator 0
            else if (first.gate == Gate.IN)
                return@Comparator -1
            else if (second.gate == Gate.IN)
                return@Comparator 1
            else if (first.gate == Gate.NOT)
                return@Comparator -1
            else if (second.gate == Gate.NOT)
                return@Comparator 1
            else if (first.gate == Gate.LSHIFT)
                return@Comparator -1
            else if (second.gate == Gate.LSHIFT)
                return@Comparator 1
            else if (first.gate == Gate.RSHIFT)
                return@Comparator -1
            else if (second.gate == Gate.RSHIFT)
                return@Comparator 1
            else
                return@Comparator 0
        }).toMutableList()
    }

    fun MutableList<Command>.resolve(): Map<String, Int> {
        val results = HashMap<String, Int>()

        val unresolved = ArrayList<Command>()
        unresolved.addAll(this)

        while (unresolved.isNotEmpty()) {
            val stillUnresolved = ArrayList<Command>()
            unresolved.forEach {
                when (it.gate) {
                    Gate.NOT -> {
                        if (results.containsOrIsNumber(it.first())) {
                            results.put(it.resultWire, results.getIfNotNumber(it.first()).not())
                        } else {
                            stillUnresolved.add(it)
                        }
                    }
                    Gate.RSHIFT -> {
                        if (results.containsOrIsNumber(it.first())) {
                            results.put(it.resultWire, results.getIfNotNumber(it.first())
                                .ushr(results.getIfNotNumber(it.second()))
                                .trimToShort())
                        } else {
                            stillUnresolved.add(it)
                        }
                    }
                    Gate.LSHIFT -> {
                        if (results.containsOrIsNumber(it.first())) {
                            results.put(it.resultWire, results.getIfNotNumber(it.first())
                                .shl(results.getIfNotNumber(it.second()))
                                .trimToShort())
                        } else {
                            stillUnresolved.add(it)
                        }
                    }
                    Gate.OR -> {
                        if (results.containsOrIsNumber(it.first()) && results.containsOrIsNumber(it.second())) {
                            results.put(it.resultWire, results.getIfNotNumber(it.first())
                                .or(results.getIfNotNumber(it.second()))
                                .trimToShort())
                        } else {
                            stillUnresolved.add(it)
                        }
                    }
                    Gate.AND -> {
                        if (results.containsOrIsNumber(it.first()) && results.containsOrIsNumber(it.second())) {
                            results.put(it.resultWire, results.getIfNotNumber(it.first())
                                .and(results.getIfNotNumber(it.second()))
                                .trimToShort())
                        } else {
                            stillUnresolved.add(it)
                        }
                    }
                    else -> {
                        // IN
                        try {
                            val res = it.first().toInt().trimToShort()
                            results.put(it.resultWire, res.trimToShort())
                        } catch (e: NumberFormatException) {

                            if (results.containsKey(it.first())) {
                                results.put(it.resultWire, results
                                    .getIfNotNumber(it.first())
                                    .trimToShort())
                            } else {
                                stillUnresolved.add(it)
                            }

                        }
                    }
                }
            }
            unresolved.clear()
            unresolved.addAll(stillUnresolved)
            stillUnresolved.clear()
        }

        return results
    }

}
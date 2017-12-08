package y2017.week2

import core.AbstractDay
import core.extensions.IntCollector
import core.extensions.collect
import core.extensions.mapToPattern

private data class Condition(val reg: String, val sign: String, val value: Int)
private data class Command(val reg: String, val isInc: Boolean, val value: Int, val cond: Condition)
private typealias Registry = MutableMap<String, Int>

class Day8(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.toCommandsAndRegistry()
        .also { (commands, registry) -> commands.forEach { it.execute(registry) } }
        .second
        .values
        .max().toString()

    override fun calculateAdvanced(): String = input.toCommandsAndRegistry()
        .let { (commands, registry) ->
            commands.collect(IntCollector()) { max, command ->
                command.execute(registry)
                registry[command.reg]?.let { if (it > max.value) max.value = it }
            }
        }
        .value
        .toString()

    private fun List<String>.toCommandsAndRegistry() = toCommands()
        .let { it to getAllRegistries(it) }

    private fun List<String>.toCommands() = mapToPattern("(.*)\\s(.{3})\\s(.*)\\sif\\s(.*)\\s(.*)\\s(.*)") {
        Command(
            reg = it[1]?.value ?: "",
            isInc = it[2]?.value?.equals("inc") ?: false,
            value = it[3]?.value?.toInt() ?: 0,
            cond = Condition(
                reg = it[4]?.value ?: "",
                sign = it[5]?.value ?: "==",
                value = it[6]?.value?.toInt() ?: 0
            )
        )
    }

    private fun getAllRegistries(commands: List<Command>) =
        commands.map { it.reg }.toSet().associate { it to 0 }.toMutableMap()

    private fun Condition.check(registry: Registry) = registry[reg]?.let {
        when (sign) {
            "==" -> it == value
            "!=" -> it != value
            ">" -> it > value
            "<" -> it < value
            ">=" -> it >= value
            "<=" -> it <= value
            else -> false
        }
    } ?: false

    private fun Command.execute(registry: Registry) {
        if (cond.check(registry)) {
            registry[reg] =
                if (isInc) registry[reg]?.plus(value) ?: 0
                else registry[reg]?.minus(value) ?: 0
        }
    }

}
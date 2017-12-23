package y2017


typealias Registry = MutableMap<String, Long>

fun Registry.safeGet(char: String) = this.getOrPut(char) { 0 }

data class Instruction(val cmd: String, val reg: String, val value: String?) {
    constructor(tokens: List<String>) : this(tokens[0], tokens[1], tokens.getOrNull(2))

    fun execute(registry: Registry, customInstructions: (Registry) -> Int? = { 1 }): Int {
        when (cmd) {
            "set" -> set(registry)
            "add" -> add(registry)
            "sub" -> sub(registry)
            "mul" -> mul(registry)
            "mod" -> mod(registry)
            "jgz" -> jgz(registry)?.let { return it }
            "jnz" -> jnz(registry)?.let { return it }
            else -> customInstructions(registry)
        }
        return 1
    }

    private fun value(registries: Registry): Long = value?.toLongOrNull() ?: registries.getOrDefault(value, 0)

    private fun set(registry: Registry) {
        value(registry).let { registry.put(reg, it) }
    }

    private fun add(registry: Registry) {
        registry.safeGet(reg).plus(value(registry)).let { registry.put(reg, it) }
    }

    private fun sub(registry: Registry) {
        registry.safeGet(reg).minus(value(registry)).let { registry.put(reg, it) }
    }

    private fun mul(registry: Registry) {
        registry.safeGet(reg).times(value(registry)).let { registry.put(reg, it) }
    }

    private fun mod(registry: Registry) {
        registry.safeGet(reg).rem(value(registry)).let { registry.put(reg, it) }
    }

    private fun jgz(registry: Registry) = (reg.toLongOrNull() ?: registry.safeGet(reg))
        .takeIf { it > 0L }
        ?.let { value(registry).toInt() }

    private fun jnz(registry: Registry) = (reg.toLongOrNull() ?: registry.safeGet(reg))
        .takeIf { it != 0L }
        ?.let { value(registry).toInt() }
}

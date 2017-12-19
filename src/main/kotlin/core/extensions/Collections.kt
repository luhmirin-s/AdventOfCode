package core.extensions

data class IntCollector(var value: Int = 0)
data class StringCollector(var value: String = "")
data class Collector<T>(var value: T)

inline fun <T, R> List<T>.collect(collector: R, crossinline action: ((R, T) -> Unit)): R {
    this.forEach { action.invoke(collector, it) }
    return collector
}

inline fun <T, R> List<T>.collectIndexed(collector: R, crossinline action: ((R, Int, T) -> Unit)): R {
    this.forEachIndexed { i, item -> action.invoke(collector, i, item) }
    return collector
}

fun <T> List<T>.joinWithoutSpaces() = this.joinToString("")

fun <T> List<T>.printEach(prefix: String? = null, suffix: String? = null): List<T> {
    prefix?.print()
    this.forEach(::println)
    suffix?.print()
    return this
}


fun <T> Collection<T>.rotate(steps: Int) = drop(steps) + take(steps)

fun <T> List<T>.swap(positions: Pair<Int, Int>): List<T> {
    val newValues = get(positions.second) to get(positions.first)
    return toMutableList().apply {
        set(positions.first, newValues.first)
        set(positions.second, newValues.second)
    }
}
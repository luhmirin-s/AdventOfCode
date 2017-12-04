package core.extensions

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

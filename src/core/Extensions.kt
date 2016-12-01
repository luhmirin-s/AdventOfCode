package core

fun <T, R> List<T>.collect(collector: R, action: ((R, T) -> Unit)): R {
    this.forEach { action.invoke(collector, it) }
    return collector
}
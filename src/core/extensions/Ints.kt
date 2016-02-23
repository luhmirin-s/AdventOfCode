package core.extensions

fun Int.isOdd(): Boolean {
    return this % 2 != 0
}

fun Int.toBinary(): String {
    return Integer.toString(this, 2)
}

fun Int.factorial(): Int {
    if (this < 1) return 1
    return 1.rangeTo(this).fold(1) { a, b -> a * b }
}
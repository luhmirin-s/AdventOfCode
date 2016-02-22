package core.extensions

fun Int.isOdd(): Boolean {
    return this % 2 != 0
}

fun Int.toBinary(): String {
    return Integer.toString(this, 2)
}

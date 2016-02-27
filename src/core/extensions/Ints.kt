package core.extensions

fun Int.isOdd() = this % 2 != 0

fun Int.toBinary() = Integer.toString(this, 2)

fun Int.factorial() =
        if (this < 1) 1
        else 1.rangeTo(this).fold(1) { a, b -> a * b }
package core.extensions

fun Int.isOdd() = this % 2 != 0

fun Int.factorial() =
    if (this < 1) 1
    else 1.rangeTo(this).fold(1) { a, b -> a * b }

fun Int.integerSqrt() = Math.round(Math.sqrt(this.toDouble())).toInt()

fun Int.sqr() = this * this

fun Int.getAllDivisors(divisors: MutableSet<Int>) {
    val root = this.integerSqrt()
    for (i in 1..(root + 1))
        if (this % i == 0) {
            divisors.add(i)
            if (i * i != this) divisors.add(this / i)
        }
}

fun Int.toIndex() = this - 1

fun Int.incLooping(size: Int) = (this + 1) % size

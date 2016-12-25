package core

import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest
import java.util.*

fun <T, R> List<T>.collect(collector: R, action: ((R, T) -> Unit)): R {
    this.forEach { action.invoke(collector, it) }
    return collector
}

fun <T, R> List<T>.collectIndexed(collector: R, action: ((R, Int, T) -> Unit)): R {
    this.forEachIndexed { i, item -> action.invoke(collector, i, item) }
    return collector
}

fun String.toListOfInts() = this.trim().split(" ").filterNot(String::isNullOrBlank).map { it.trim().toInt() }

fun String.md5Hex(): String {
    val bytes = this.toByteArray(Charset.forName("UTF-8"))
    val digest = MessageDigest.getInstance("MD5").digest(bytes)

    val hexStr = BigInteger(1, digest).toString(16)

    return hexStr.addLeadingZeros()
}

fun String.addLeadingZeros(maxLength: Int = 32): String {
    if (this.length >= maxLength) return this

    val pattern = "%0" + (maxLength - this.length) + "d%s"
    return String.format(pattern, 0, this)
}

fun <T> List<T>.joinWithoutSpaces() = this.joinToString("")

fun String.toIndex() = this.toInt() - 1
fun Int.toIndex() = this - 1

fun Int.isOdd() = this % 2 != 0

fun Int.toBinary() = Integer.toString(this, 2)

fun <T> List<T>.printEach(prefix: String? = null, suffix: String? = null): List<T> {
    prefix?.print()
    this.forEach(::println)
    suffix?.print()
    return this
}

fun <T> T.print() {
    println(this)
}

fun Int.factorial() =
        if (this < 1) 1
        else 1.rangeTo(this).fold(1) { a, b -> a * b }

fun <T> Set<T>.permutations(): List<List<T>> {
    val initList = this.toList()
    return (0..initList.size.factorial() - 1).map { permutation(it, initList) }
}

private fun <T> permutation(no: Int, items: List<T>) = permutationHelper(no, LinkedList(items), ArrayList())

private fun <T> permutationHelper(no: Int, input: MutableList<T>, output: MutableList<T>): List<T> {
    if (input.isEmpty()) return output
    val subFactorial = (input.size - 1).factorial()
    output.add(input.removeAt(no / subFactorial))
    return permutationHelper((no % subFactorial), input, output)
}
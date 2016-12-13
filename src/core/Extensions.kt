package core

import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest

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
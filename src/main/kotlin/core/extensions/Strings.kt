package core.extensions

import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest

fun String.md5Hex(): String {
    val bytes = this.toByteArray(Charset.forName("UTF-8"))
    val digest = MessageDigest.getInstance("MD5").digest(bytes)

    return BigInteger(1, digest).toString(16).padStart(32, '0')
}

fun String.toIntOrElse(default: Int): Int = this.toIntOrNull() ?: default

fun String.getLastWord(): String = this.split(' ').last()

fun String.toListOfInts() = this.trim().split(" ").filterNot(String::isNullOrBlank).map { it.trim().toInt() }

fun String.toIndex() = this.toInt() - 1

fun String.toCharList() = toCharArray().toList()

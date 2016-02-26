package core.extensions

import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest

fun String.md5Hex(): String {
    val bytes = this.toByteArray(Charset.forName("UTF-8"))
    val digest = MessageDigest.getInstance("MD5").digest(bytes)

    val hexStr = BigInteger(1, digest).toString(16)

    return hexStr.addLeadingZeros()
}

fun String.addLeadingZeros(maxLength: Int = 32): String {
    if (this.length >= maxLength) return this;

    val pattern = "%0" + (maxLength - this.length) + "d%s"
    return String.format(pattern, 0, this);
}

fun String.toIntOrElse(default: Int) : Int {
    try {
        return this.toInt()
    } catch (e: NumberFormatException) {
        return default
    }
}
package y2016.week2

import core.AbstractDay

class Day9(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        return inputFirstLine.decompressedSize().toString()
    }

    override fun calculateAdvanced(): String {
        return inputFirstLine.recursiveDecompressedSize().toString()
    }

    fun String.decompressedSize(): Long {
        var newLineSize = 0L
        var i = 0
        while (i < this.length) {
            if (this[i].isStartOfToken()) {
                val token = getTokenString(i).toToken()

                newLineSize += token.count * token.times
                i += (token.length + token.count)
            } else {
                newLineSize++
                i++
            }
        }
        return newLineSize
    }


    fun String.recursiveDecompressedSize(): Long {
        var newLineSize = 0L
        var i = 0
        while (i < this.length) {
            if (this[i].isStartOfToken()) {
                val token = getTokenString(i).toToken()

                i += token.length
                val newLine = this.substring(i..(i + token.count - 1))
                newLineSize += newLine.recursiveDecompressedSize() * token.times
                i += token.count
            } else {
                newLineSize++
                i++
            }
        }
        return newLineSize
    }

    private fun Char.isStartOfToken() = this == '('

    private fun String.getTokenString(i: Int): String {
        val end = i + this.substring(i).indexOfFirst { it == ')' }
        return this.substring(i..end)
    }

    data class Token(val count: Int, val times: Int, val length: Int)

    fun String.toToken(): Token {
        val values = this.split(Regex("[\\(\\)x]")).filter(String::isNotEmpty).map(String::toInt)
        return Token(values[0], values[1], this.length)
    }
}
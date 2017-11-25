package y2015.week1

import core.extensions.md5Hex
import y2015.DayOf2015

class Day4 : DayOf2015("day_4") {

    override fun calculate(): String {
        return inputFirstLine()
            .firstsMd5ThatStartsWith("00000")
            .toString()
    }

    override fun calculateAdvanced(): String {
        return inputFirstLine()
            .firstsMd5ThatStartsWith("000000")
            .toString()
    }

    private fun String.firstsMd5ThatStartsWith(resultPrefix: String): Int {
        var suffix = 1
        while (!"%s%d".format(this, suffix).md5Hex().startsWith(resultPrefix)) {
            suffix++
        }
        return suffix
    }
}
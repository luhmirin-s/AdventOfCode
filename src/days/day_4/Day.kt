package days.day_4

import core.AbstractDay
import core.extensions.md5Hex

class Day : AbstractDay("day_4") {

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
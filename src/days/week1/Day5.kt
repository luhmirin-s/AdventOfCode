package days.week1

import core.AbstractDay
import core.md5Hex

class Day5 : AbstractDay("week1/day_5") {

    override fun calculate(): String {
        val prefix = inputFirstLine()
        val result = mutableListOf<Char>()
        for (i in 0..10000000) {
            val hex = "$prefix$i".md5Hex()
            if (hex.startsWith("00000")) {
                result.add(hex[5])
                if (result.size == 8) break
            }
        }
        return result.joinToString("")
    }

    override fun calculateAdvanced(): String {
        val prefix = inputFirstLine()
        val result = sortedMapOf<Int, Char>()
        for (i in 0..50000000) {
            val hex = "$prefix$i".md5Hex()
            if (hex.startsWith("00000") && hex[5] in '0'..'7') {
                val key = hex[5].toInt() - 48
                if (!result.containsKey(key)) {
                    result[key] = hex[6]
                    if (result.size == 8) break
                }
            }
        }
        return result.toList().map { it.second }.joinToString("")
    }
}
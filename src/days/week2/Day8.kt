package days.week2

import core.AbstractDay
import java.util.*

class Day8 : AbstractDay("day_8") {

    val CODE_PATTERN = "\\\\x[a-f0-9]{2}"

    override fun calculate(): String {

        var countCodeChars = input().map { it.length }.sum()
        var countChars = input().map {
            it.toLowerCase()
                    .replace("\\\\", "X")
                    .replace("\\\"", "X")
                    .replace(Regex(CODE_PATTERN), "X")
                    .length - 2 //2 for surrounding quotes
        }.sum()
        return (countCodeChars - countChars).toString()
    }

    override fun calculateAdvanced(): String {

        var initialCodeChars = input().map { it.length }.sum()
        var countCodeChars = input().map {
            it.toLowerCase()
                    .replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .length + 2 //2 for surrounding quotes
        }.sum()
        return (countCodeChars - initialCodeChars).toString()
    }
}

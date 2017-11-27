package y2015.week2

import core.AbstractDay

class Day8(input: List<String>) : AbstractDay(input) {

    val CODE_PATTERN = "\\\\x[a-f0-9]{2}"

    override fun calculate(): String {

        val countCodeChars = input.map { it.length }.sum()
        val countChars = input.map {
            it.toLowerCase()
                .replace("\\\\", "X")
                .replace("\\\"", "X")
                .replace(Regex(CODE_PATTERN), "X")
                .length - 2 //2 for surrounding quotes
        }.sum()
        return (countCodeChars - countChars).toString()
    }

    override fun calculateAdvanced(): String {

        val initialCodeChars = input.map { it.length }.sum()
        val countCodeChars = input.map {
            it.toLowerCase()
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .length + 2 //2 for surrounding quotes
        }.sum()
        return (countCodeChars - initialCodeChars).toString()
    }
}

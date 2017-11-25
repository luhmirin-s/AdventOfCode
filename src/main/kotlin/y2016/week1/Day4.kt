package y2016.week1

import core.extensions.joinWithoutSpaces
import y2016.DayOf2016

class Day4 : DayOf2016("week1/day_4") {

    override fun calculate(): String {
        return input().map { it.breakToList().toEntry() }
            .filter { it.calculatedSum() == it.sum }
            .sumBy { it.id }
            .toString()
    }

    override fun calculateAdvanced(): String {
        return input().map { it.breakToList().toEntry() }
            .filter { it.calculatedSum() == it.sum && it.decode() == "northpole object storage" }
            .first().id.toString()
    }

    private fun String.breakToList(): List<String> = this.split(Regex("[-\\[\\]]")).filterNot(String::isNullOrEmpty)

    private data class Entry(val words: List<String>, val id: Int, val sum: String) {

        fun calculatedSum(): String {
            val charMap = mutableMapOf<Char, Int>()
            words.joinWithoutSpaces().toList().sorted().forEach {
                val count = charMap.getOrPut(it) { 0 }
                charMap.put(it, count + 1)
            }
            return charMap.toList()
                .sortedWith(compareBy<Pair<Char, Int>>({ -it.second }, { it.first }))
                .map { it.first }.joinWithoutSpaces()
                .substring(0..4)
        }

        fun decode() = words.map { it.toList().map { rotate(it, id % 26) }.joinToString("") }.joinToString(" ")

        private fun rotate(char: Char, offset: Int) = ((char.toInt() - 97 + offset) % 26 + 97).toChar()

    }

    private fun List<String>.toEntry(): Entry {
        val hash = this.last()
        val id = this.dropLast(1).last().toInt()
        return Entry(this.dropLast(2), id, hash)
    }
}



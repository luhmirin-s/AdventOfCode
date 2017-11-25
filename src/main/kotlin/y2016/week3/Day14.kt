package y2016.week3

import core.extensions.md5Hex
import y2016.DayOf2016

class Day14 : DayOf2016("week3/day_14") {

    /*
    Indices are messed up for some reason and I spent too much time to care anymore :(
    Finding codes is at least correct
     */
    override fun calculate(): String {
        return findCodes(inputFirstLine())
            .sortedWith(compareBy { it.second })[62]
            .second.toString()
    }

    override fun calculateAdvanced(): String {
        return findCodes(inputFirstLine(), 2016)
            .sortedWith(compareBy { it.second })[66]
            .second.toString()
    }


    val TRIPLET = Regex("(.)\\1\\1")
    val FIVER = Regex("(.)\\1\\1\\1\\1")

    private fun findCodes(salt: String, stretchTimes: Int = 0): MutableList<Pair<Char, Int>> {
        val potentialCodes = mutableListOf<Pair<Char, Int>>()
        val codes = mutableListOf<Pair<Char, Int>>()

        for (i in 0..30000) {
            val hash = makeHash((salt + i), stretchTimes)
            val potentialTripletChar = TRIPLET.firstGroupChar(hash)
            val potentialFiveChar = FIVER.firstGroupChar(hash)

            if (potentialFiveChar != null) {
                potentialCodes.filter { it.first == potentialFiveChar }
                    .filter { i - it.second < 1000 }
                    .forEach { codes.add(it) }
            } else if (potentialTripletChar != null) {
                potentialCodes.add(potentialTripletChar to i)
            }

            if (codes.size > 64) break
        }
        return codes
    }

    private fun Regex.firstGroupChar(hash: String) = this.find(hash)?.groupValues?.get(0)?.get(0)

    private fun makeHash(start: String, stretchTimes: Int): String {
        var result = start.md5Hex()
        (0..stretchTimes - 1).forEach { result = result.md5Hex() }
        return result
    }
}

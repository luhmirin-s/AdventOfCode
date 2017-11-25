package y2015.week4

import y2015.DayOf2015
import java.util.*

class Day19 : DayOf2015("day_19") {

    val molecule = "CRnCaCaCaSiRnBPTiMgArSiRnSiRnMgArSiRnCaFArTiTiBSiThFYCaFArCaCaSiThCaPBSiThSiThCaCaPTiRnPBSiThRnFArArCaCaSiThCaSiThSiRnMgArCaPTiBPRnFArSiThCaSiRnFArBCaSiRnCaPRnFArPMgYCaFArCaPTiTiTiBPBSiThCaPTiBPBSiRnFArBPBSiRnCaFArBPRnSiRnFArRnSiRnBFArCaFArCaCaCaSiThSiThCaCaPBPTiTiRnFArCaPTiBSiAlArPBCaCaCaCaCaSiRnMgArCaSiThFArThCaSiThCaSiRnCaFYCaSiRnFYFArFArCaSiRnFYFArCaSiRnBPMgArSiThPRnFArCaSiRnFArTiRnSiRnFYFArCaSiRnBFArCaSiRnTiMgArSiThCaSiThCaFArPRnFArSiRnFArTiTiTiTiBCaCaSiRnCaCaFYFArSiThCaPTiBPTiBCaSiThSiRnMgArCaF"

    override fun calculate(): String {
        return input()
            .parseReplacements()
            .getPossibleReplacements(molecule)
            .count()
            .toString()
    }

    override fun calculateAdvanced(): String {
        // I cheated a bit on this
        // https://www.reddit.com/r/adventofcode/comments/3xflz8/day_19_solutions/cy4etju

        return (
            molecule.count { it.isUpperCase() }
                - molecule.replace("Rn", "#").replace("Ar", "#").count { it.equals('#') }
                - 2 * molecule.count { it.equals('Y') }
                - 1
            ).toString()
    }

    private fun List<String>.parseReplacements(): Map<String, MutableList<String>> {
        val replacements: MutableMap<String, MutableList<String>> = HashMap()

        this.forEach {
            val tokens = it.split(" => ")

            if (replacements.containsKey(tokens[0])) {
                replacements[tokens[0]]?.add(tokens[1])
            } else {
                replacements[tokens[0]] = ArrayList()
                replacements[tokens[0]]?.add(tokens[1])
            }
        }
        return replacements
    }

    private fun Map<String, List<String>>.getPossibleReplacements(originalString: String): Set<String> {
        val derived: MutableSet<String> = HashSet()

        this.entries.forEach { entry ->
            var lastIndex = 0;
            while (lastIndex != -1) {
                lastIndex = originalString.indexOf(entry.key, lastIndex)

                if (lastIndex != -1) {
                    entry.value.forEach {
                        derived.add(originalString.replaceAtIndex(lastIndex, entry.key.length, it))
                    }

                    lastIndex += entry.key.length
                }
            }
        }
        return derived
    }

    private fun String.replaceAtIndex(index: Int, length: Int, replacement: String): String {
        return this.substring(0, index) + replacement + this.substring(index + length, this.length)
    }

}
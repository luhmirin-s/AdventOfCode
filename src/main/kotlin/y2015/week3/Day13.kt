package y2015.week3

import core.AbstractDay
import core.extensions.permutations
import core.extensions.toIntOrElse
import java.util.*

class Day13(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val names: MutableSet<String> = HashSet()
        val happinessChanges = input.map { str ->
            val tokens = str.split(" ")
            names.add(tokens[0])
            Happiness(tokens[0], tokens[10].removeSuffix("."), parseNumber(tokens))
        }

        return names.permutations()
            .toHappinessChangeList(happinessChanges)
            .max().toString()
    }

    override fun calculateAdvanced(): String {
        val names: MutableSet<String> = HashSet()
        val happinessChanges: MutableList<Happiness> = ArrayList()
        input.forEach { str ->
            val tokens = str.split(" ")
            names.add(tokens[0])
            happinessChanges.add(Happiness(tokens[0], tokens[10].removeSuffix("."), tokens[2].toSign() * tokens[3].toIntOrElse(0)))
        }
        // plugging "me" in
        names.toList().forEach {
            happinessChanges.add(Happiness(it, "me", 0))
            happinessChanges.add(Happiness("me", it, 0))
        }
        names.add("me")

        return names.permutations()
            .toHappinessChangeList(happinessChanges)
            .max().toString()
    }


    private fun parseNumber(tokens: List<String>) = tokens[2].toSign() * tokens[3].toIntOrElse(0)

    private fun String.toSign() = if (this == "lose") -1 else 1


    private data class Happiness(val who: String, val neighbour: String, val change: Int)

    private fun List<List<String>>.toHappinessChangeList(happinessChanges: List<Happiness>) =
        this.map { nameSequence ->
            val changes: MutableList<Int> = ArrayList()
            nameSequence.forEachIndexed { i, name ->
                // add to changes one before and one after current
                if (i == 0) {
                    // handle first
                    changes.add(happinessChanges.findHappinessChange(name, nameSequence[nameSequence.size - 1]))
                    changes.add(happinessChanges.findHappinessChange(name, nameSequence[1]))
                } else if (i == nameSequence.size - 1) {
                    // handle last
                    changes.add(happinessChanges.findHappinessChange(name, nameSequence[i - 1]))
                    changes.add(happinessChanges.findHappinessChange(name, nameSequence[0]))
                } else {
                    // handle middle
                    changes.add(happinessChanges.findHappinessChange(name, nameSequence[i - 1]))
                    changes.add(happinessChanges.findHappinessChange(name, nameSequence[i + 1]))
                }
            }
            changes.sum()
        }

    private fun List<Happiness>.findHappinessChange(name: String, neighbour: String) =
        first { it.who.equals(name) && it.neighbour.equals(neighbour) }.change
}
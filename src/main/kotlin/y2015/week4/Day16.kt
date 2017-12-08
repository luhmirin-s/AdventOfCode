package y2015.week4

import core.AbstractDay
import java.util.*

class Day16(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.map { it.parseAunt() }
        .filter { it.things.noKeyOrExactly("children", 3) }
        .filter { it.things.noKeyOrExactly("cats", 7) }
        .filter { it.things.noKeyOrExactly("samoyeds", 2) }
        .filter { it.things.noKeyOrExactly("pomeranians", 3) }
        .filter { it.things.noKeyOrExactly("akitas", 0) }
        .filter { it.things.noKeyOrExactly("vizslas", 0) }
        .filter { it.things.noKeyOrExactly("goldfish", 5) }
        .filter { it.things.noKeyOrExactly("trees", 3) }
        .filter { it.things.noKeyOrExactly("cars", 2) }
        .filter { it.things.noKeyOrExactly("perfumes", 1) }
        .first().num
        .toString()


    override fun calculateAdvanced(): String = input.map { it.parseAunt() }
        .filter { it.things.noKeyOrExactly("children", 3) }
        .filter { it.things.noKeyOrMoreThan("cats", 7) }
        .filter { it.things.noKeyOrExactly("samoyeds", 2) }
        .filter { it.things.noKeyOrLessThan("pomeranians", 3) }
        .filter { it.things.noKeyOrExactly("akitas", 0) }
        .filter { it.things.noKeyOrExactly("vizslas", 0) }
        .filter { it.things.noKeyOrLessThan("goldfish", 5) }
        .filter { it.things.noKeyOrMoreThan("trees", 3) }
        .filter { it.things.noKeyOrExactly("cars", 2) }
        .filter { it.things.noKeyOrExactly("perfumes", 1) }
        .first().num
        .toString()


    private data class Aunt(val num: Int, var things: Map<String, Int>)

    private fun String.parseAunt(): Aunt {
        val tokens = this.split(" ")
        val num = tokens[1].removeSuffix(":").toInt()
        val thingMap: MutableMap<String, Int> = HashMap()

        thingMap.put(tokens[2].removeSuffix(":"), tokens[3].removeSuffix(",").toInt())
        thingMap.put(tokens[4].removeSuffix(":"), tokens[5].removeSuffix(",").toInt())
        thingMap.put(tokens[6].removeSuffix(":"), tokens[7].toInt())
        return Aunt(num, thingMap)
    }

    private fun Map<String, Int>.noKeyOrExactly(key: String, amount: Int)
        = if (!this.containsKey(key)) true else this[key] == amount

    private fun Map<String, Int>.noKeyOrMoreThan(key: String, amount: Int)
        = if (!this.containsKey(key)) true else this[key] ?: 0 > amount

    private fun Map<String, Int>.noKeyOrLessThan(key: String, amount: Int)
        = if (!this.containsKey(key)) true else this[key] ?: 0 < amount
}
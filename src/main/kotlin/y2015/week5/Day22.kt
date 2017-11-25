package y2015.week5

import core.extensions.getLastWord
import y2015.DayOf2015
import java.util.*

/**
 * For this days answer I take no credit.
 * Just translated solution from: https://www.reddit.com/r/adventofcode/comments/3xspyl/day_22_solutions/cy7rt7f
 *
 * I just want to finish my tree. :)
 */
class Day22 : DayOf2015("day_22") {

    private val SPELL_COSTS = listOf(53, 73, 113, 173, 229)
    private val SPELL_TIMERS = listOf(1, 1, 6, 6, 5)

    private var nodes: Queue<Node> = LinkedList()

    override fun calculate(): String {
        return iterateGame()
    }

    override fun calculateAdvanced(): String {
        return iterateGame(true)
    }


    private data class Node(
        var hero_hp: Int,
        var hero_mana: Int,
        var hero_armor: Int,
        var boss_hp: Int,
        var boss_damage: Int,
        var mana_spent: Int,
        var spellTimers: Array<Int>,
        var is_hero_turn: Boolean
    )

    private fun Node.deepCopy(): Node = this.copy(spellTimers = this.spellTimers.copyOf())

    private val initialNode = Node(
        hero_hp = 50,
        hero_mana = 500,
        hero_armor = 0,
        boss_hp = input()[0].getLastWord().toInt(),
        boss_damage = input()[1].getLastWord().toInt(),
        mana_spent = 0,
        spellTimers = arrayOf(0, 0, 0, 0, 0),
        is_hero_turn = true
    )

    private fun iterateGame(hardMode: Boolean = false): String {
        nodes.clear()
        nodes.add(initialNode)

        while (nodes.isNotEmpty()) {
            val currentNode = nodes.poll()

            // so that currentNode is always non-null
            if (currentNode == null) return "-1"

            // refresh armor
            currentNode.hero_armor = 0

            if (hardMode && currentNode.is_hero_turn) {
                currentNode.hero_hp -= 1
                if (currentNode.hero_hp <= 0) continue
            }

            // spell effects
            for (i in 0..4) {
                if (currentNode.spellTimers[i] > 0) {
                    currentNode.spellTimers[i] -= 1
                    when (i) {
                        0 -> currentNode.boss_hp -= 4 // missile
                        1 -> {
                            currentNode.boss_hp -= 2  // drain
                            currentNode.hero_hp += 2
                        }
                        2 -> currentNode.hero_armor = 7  // shield
                        3 -> currentNode.boss_hp -= 3  // poison
                        4 -> currentNode.hero_mana += 101 // recharge
                    }
                }
            }

            // check win/lose conditions
            if (currentNode.hero_hp <= 0) continue
            if (currentNode.boss_hp <= 0) return currentNode.mana_spent.toString()

            // turn itself
            if (currentNode.is_hero_turn) {
                // add new node for each available spell
                for (i in 0..4) {
                    if (currentNode.spellTimers[i] == 0 && currentNode.hero_mana >= SPELL_COSTS[i]) {
                        val newNode = currentNode.deepCopy()
                        newNode.hero_mana -= SPELL_COSTS[i]
                        newNode.mana_spent += SPELL_COSTS[i]
                        newNode.spellTimers[i] = SPELL_TIMERS[i]
                        newNode.is_hero_turn = !newNode.is_hero_turn
                        nodes.add(newNode)
                    }
                }
            } else {
                val newNode = currentNode.deepCopy()
                newNode.hero_hp -= Math.max(1, currentNode.boss_damage - currentNode.hero_armor)
                newNode.is_hero_turn = !newNode.is_hero_turn
                nodes.add(newNode)
            }
        }
        return "-2"
    }
}
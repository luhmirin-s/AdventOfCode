package y2015.week5

import core.AbstractDay
import java.util.*

class Day21(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val boss = input.parseBoss()

        return ITEM_SETS()
            .filter {
                var turnsToKillBoss = boss.hp / getTotalDamage(it.dmg, boss.def)
                if (boss.hp % getTotalDamage(it.dmg, boss.def) != 0) turnsToKillBoss++
                (turnsToKillBoss - 1) * getTotalDamage(boss.dmg, it.def) < 100
            }.minBy { it.cost }
            ?.cost.toString()
    }

    override fun calculateAdvanced(): String {
        val boss = input.parseBoss()

        return ITEM_SETS()
            .filter {
                (100 / getTotalDamage(boss.dmg, it.def)) * getTotalDamage(it.dmg, boss.def) < boss.hp
            }.maxBy { it.cost }
            ?.cost.toString()
    }


    private fun getTotalDamage(dmg: Int, def: Int): Int = if (dmg > def) dmg - def else 1

    private data class Boss(val hp: Int, val dmg: Int, val def: Int)

    private fun List<String>.parseBoss(): Boss {
        val values = this.map { it.split(": ")[1].toInt() }
        return Boss(values[0], values[1], values[2])
    }

    private data class Item(val cost: Int, val dmg: Int, val def: Int)

    private fun Item.combine(other: Item): Item = Item(this.cost + other.cost, this.dmg + other.dmg, this.def + other.def)

    private val WEAPONS = setOf(
        Item(8, 4, 0),
        Item(10, 5, 0),
        Item(25, 6, 0),
        Item(40, 7, 0),
        Item(74, 8, 0)
    )

    private val ARMORS = setOf(
        Item(0, 0, 0), //none
        Item(13, 0, 1),
        Item(31, 0, 2),
        Item(53, 0, 3),
        Item(75, 0, 4),
        Item(102, 0, 5)
    )

    private fun RING_PAIRS(): Set<Item> {
        val list: MutableSet<Item> = HashSet()
        val ATTACK_RINGS = setOf(
            Item(0, 0, 0), //none
            Item(25, 1, 0),
            Item(50, 2, 0),
            Item(100, 3, 0)
        )
        val ARMOR_RING = setOf(
            Item(0, 0, 0), //none
            Item(20, 0, 1),
            Item(40, 0, 2),
            Item(80, 0, 3)
        )
        val allRings = ATTACK_RINGS.plus(ARMOR_RING)
        allRings.forEach { first ->
            allRings.forEach { second ->
                if (first != second) list.add(first.combine(second))
            }
        }
        list.add(Item(0, 0, 0)) //none
        return list
    }

    private fun ITEM_SETS(): Set<Item> {
        val list: MutableSet<Item> = HashSet()
        RING_PAIRS().forEach { r ->
            WEAPONS.forEach { w ->
                ARMORS.forEach { a ->
                    list.add(w.combine(a).combine(r))
                }
            }
        }
        return list
    }
}


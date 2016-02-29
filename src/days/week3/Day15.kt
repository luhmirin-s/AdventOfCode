package days.week3

import core.AbstractDay
import java.util.*

class Day15 : AbstractDay("day_15") {

    override fun calculate(): String {
        return input()
                .map { it.parseIngredients() }
                .calculateAndFilter()
                .map { it.getTotal() }
                .max().toString()
    }

    override fun calculateAdvanced(): String {
        return input()
                .map { it.parseIngredients() }
                .calculateAndFilter()
                .filter { it.cal == 500 }
                .map { it.getTotal() }
                .max().toString()
    }


    private data class Ingredient(val cap: Int, val dur: Int, val fla: Int, val tex: Int, val cal: Int)

    private fun String.parseIngredients(): Ingredient {
        var tokens = this.split(" ")
        return Ingredient(
                tokens[2].intWithoutComma(),
                tokens[4].intWithoutComma(),
                tokens[6].intWithoutComma(),
                tokens[8].intWithoutComma(),
                tokens[10].intWithoutComma())
    }

    private fun String.intWithoutComma() = this.removeSuffix(",").toInt()

    private fun List<Ingredient>.calculateAndFilter(): List<Ingredient> {
        val N = 100
        val caps = this.map { it.cap }
        val durs = this.map { it.dur }
        val flas = this.map { it.fla }
        val texs = this.map { it.tex }
        val cals = this.map { it.cal }

        var totals: MutableList<Ingredient> = ArrayList()
        // not the most efficient way
        for (n1 in N downTo 0)
            for (n2 in (N - n1) downTo 0)
                for (n3 in (N - n1 - n2) downTo 0)
                    for (n4 in (N - n1 - n2 - n3) downTo 0) {
                        if (n1 + n2 + n3 + n4 != N) continue

                        val capSum = n1 * caps[0] + n2 * caps[1] + n3 * caps[2] + n4 * caps[3]
                        if (capSum < 0) continue

                        val durSum = n1 * durs[0] + n2 * durs[1] + n3 * durs[2] + n4 * durs[3]
                        if (durSum < 0) continue

                        val flaSum = n1 * flas[0] + n2 * flas[1] + n3 * flas[2] + n4 * flas[3]
                        if (flaSum < 0) continue

                        val texSum = n1 * texs[0] + n2 * texs[1] + n3 * texs[2] + n4 * texs[3]
                        if (texSum < 0) continue

                        val calSum = n1 * cals[0] + n2 * cals[1] + n3 * cals[2] + n4 * cals[3]

                        totals.add(Ingredient(capSum, durSum, flaSum, texSum, calSum))
                    }
        return totals.toList()
    }

    private fun Ingredient.getTotal() = this.cap * this.dur * this.fla * this.tex
}



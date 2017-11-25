package y2016.week2

import y2016.DayOf2016

class Day10 : DayOf2016("week2/day_10") {

    override fun calculate(): String {
        val bots = mutableMapOf<Int, Bot>()
        val outputs = mutableMapOf<Int, Bot>()
        var firstIndexForCondition = 0

        input().forEach {
            updateBots(bots, it, outputs)
            tryResolveBots(bots) { v1, v2, i ->
                if ((v1 == 17 && v2 == 61) || (v1 == 61 && v2 == 17)) firstIndexForCondition = i
            }
        }

        return firstIndexForCondition.toString()
    }


    override fun calculateAdvanced(): String {
        val bots = mutableMapOf<Int, Bot>()
        val outputs = mutableMapOf<Int, Bot>()

        input().forEach {
            updateBots(bots, it, outputs)
            tryResolveBots(bots, null)
        }

        return ((outputs[0]?.values?.get(0) ?: 0)
            * (outputs[1]?.values?.get(0) ?: 0)
            * (outputs[2]?.values?.get(0) ?: 0)).toString()
    }


    data class Bot(
        val index: Int,
        var lowTo: Bot?,
        var highTo: Bot?,
        val values: MutableList<Int> = mutableListOf()
    )

    private fun MutableMap<Int, Bot>.getBot(indexToken: String) =
        this.getOrPut(indexToken.toInt()) { Bot(indexToken.toInt(), null, null, mutableListOf()) }

    private fun updateBots(bots: MutableMap<Int, Bot>, it: String, outputs: MutableMap<Int, Bot>) {
        val tokens = it.split(" ")

        if (tokens[0] == "bot") {
            val bot = bots.getBot(tokens[1])

            bot.lowTo = if (tokens[5] == "output") outputs.getBot(tokens[6]) else bots.getBot(tokens[6])
            bot.highTo = if (tokens[10] == "output") outputs.getBot(tokens[11]) else bots.getBot(tokens[11])

        } else {
            val bot = bots.getBot(tokens[5])
            bot.values.add(tokens[1].toInt())
        }
    }

    private fun tryResolveBots(bots: MutableMap<Int, Bot>, condition: ((Int, Int, Int) -> Unit)?) {
        var isResolved = true
        while (isResolved) {
            val unresolvedBots = bots.filter { it.value.lowTo != null && it.value.highTo != null && it.value.values.size >= 2 }
            isResolved = unresolvedBots.isNotEmpty()

            unresolvedBots.map { it.value }.forEach {
                val val1 = it.values.removeAt(0)
                val val2 = it.values.removeAt(0)
                condition?.invoke(val1, val2, it.index)

                it.lowTo!!.values.add(Math.min(val1, val2))
                it.highTo!!.values.add(Math.max(val1, val2))
            }
        }
    }
}
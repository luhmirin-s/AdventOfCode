package y2016

import core.AbstractDay
import core.extensions.toIndex

class Day21(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        var letters = "abcdefgh".toCharArray().toMutableList().toMutableMap()
        input.forEach {
            letters = it.split(" ").execute(letters)
        }
        return letters.values.joinToString("")
    }

    override fun calculateAdvanced(): String {
        var letters = "fbgdceah".toCharArray().toMutableList().toMutableMap()

        input.reversed().forEach {
            letters = it.split(" ").execute(letters, reversed = true)
        }
        return letters.values.joinToString("")
    }

    private fun List<String>.execute(letters: MutableMap<Int, Char>, reversed: Boolean = false): MutableMap<Int, Char> {
        val command = "${this[0]} ${this[1]}"
        return when (command) {
            "swap position" -> letters.swapPositions(this[2].toInt(), this[5].toInt())
            "swap letter" -> letters.swapLetters(this[2][0], this[5][0])
            "reverse positions" -> letters.reverse(this[2].toInt(), this[4].toInt())
            else -> if (!reversed) {
                return when (command) {
                    "rotate left" -> letters.rotate(true, this[2].toInt())
                    "rotate right" -> letters.rotate(false, this[2].toInt())
                    "rotate based" -> letters.rotateBased(this[6][0])
                    "move position" -> letters.move(this[2].toInt(), this[5].toInt())
                    else -> letters
                }
            } else {
                return when (command) {
                    "rotate left" -> letters.rotate(false, this[2].toInt())
                    "rotate right" -> letters.rotate(true, this[2].toInt())
                    "rotate based" -> letters.rotateBasedReversed(this[6][0])
                    "move position" -> letters.move(this[5].toInt(), this[2].toInt())
                    else -> letters
                }
            }
        }
    }

    private fun MutableList<Char>.toMutableMap() = this.mapIndexed { i, c -> i to c }.toMap() as MutableMap<Int, Char>

    private fun MutableMap<Int, Char>.swapPositions(x: Int, y: Int): MutableMap<Int, Char> {
        val charAtX = this[x]!!
        val charAtY = this[y]!!

        this[x] = charAtY
        this[y] = charAtX
        return this
    }

    private fun MutableMap<Int, Char>.swapLetters(x: Char, y: Char): MutableMap<Int, Char> {
        val positionOfX = this.values.indexOf(x)
        val positionOfY = this.values.indexOf(y)
        return this.swapPositions(positionOfX, positionOfY)
    }

    private fun MutableMap<Int, Char>.reverse(x: Int, y: Int): MutableMap<Int, Char> {
        var from = x
        var through = y
        var newLetters = this

        while (from < through) {
            newLetters = newLetters.swapPositions(from, through)
            from++
            through--
        }
        return newLetters
    }

    private fun MutableMap<Int, Char>.rotate(isLeft: Boolean, x: Int): MutableMap<Int, Char> {
        val letters = this.values.toMutableList()

        for (i in 0..x.toIndex()) {
            val pushedOne = if (isLeft) letters.removeAt(0)
            else letters.removeAt(letters.lastIndex)

            if (isLeft) letters.add(pushedOne)
            else letters.add(0, pushedOne)
        }
        return letters.toMutableMap()
    }

    private fun MutableMap<Int, Char>.move(x: Int, y: Int): MutableMap<Int, Char> {
        val letters = this.values.toMutableList()

        val c = letters.removeAt(x)
        letters.add(y, c)
        return letters.toMutableMap()
    }

    private fun MutableMap<Int, Char>.rotateBased(c: Char): MutableMap<Int, Char> {
        val index = this.values.indexOf(c)
        val totalRotations = 1 + index + if (index >= 4) 1 else 0
        return this.rotate(false, totalRotations)
    }

    private fun MutableMap<Int, Char>.rotateBasedReversed(c: Char): MutableMap<Int, Char> {
        val index = when (this.values.indexOf(c)) {
            0 -> 1
            1 -> 1
            2 -> 6
            3 -> 2
            4 -> 7
            5 -> 3
            6 -> 0
            else -> 4
        }
        return this.rotate(true, index)
    }

}


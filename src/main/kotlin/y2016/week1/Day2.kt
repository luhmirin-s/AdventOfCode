package y2016.week1

import core.AbstractDay


class Day2(input: List<String>) : AbstractDay(input) {
    override fun calculate(): String {
        var result = ""
        var btm = SquareButton(5)

        input.map(String::toCharArray).forEach { arr ->
            arr.forEach { ch -> btm = btm.move(ch) }
            result += btm.value.toString()
        }
        return result
    }

    override fun calculateAdvanced(): String {
        var result = ""
        var btm = RombButton(5)

        input.map(String::toCharArray).forEach { arr ->
            arr.forEach { ch -> btm = btm.move(ch) }
            result += btm.stringValue()
        }
        return result
    }

    data class SquareButton(val value: Int) {
        /*
         1 2 3
         4 5 6
         7 8 9
         */
        val topBorder = listOf(1, 2, 3)
        val bottomBorder = listOf(7, 8, 9)
        val rightBorder = listOf(3, 6, 9)
        val leftBorder = listOf(1, 4, 7)

        fun move(direction: Char): SquareButton {
            return when (direction) {
                'U' -> newButton(topBorder) { value -> value - 3 }
                'D' -> newButton(bottomBorder) { value -> value + 3 }
                'R' -> newButton(rightBorder) { value -> value + 1 }
                else -> newButton(leftBorder) { value -> value - 1 } // L
            }
        }

        private fun newButton(border: List<Int>, valueProvider: (Int) -> Int)
            = if (border.contains(this.value)) this else SquareButton(valueProvider(this.value))

    }

    data class RombButton(val value: Int) {
        /*
            1
          2 3 4
        5 6 7 8 9
          A B C
            D
         A=10 B=11 C=12 D=13
         */
        val topBorder = listOf(5, 2, 1, 4, 9)
        val bottomBorder = listOf(5, 10, 13, 12, 9)
        val rightBorder = listOf(1, 4, 9, 12, 13)
        val leftBorder = listOf(1, 2, 5, 10, 13)

        fun stringValue() = when (value) {
            in 1..9 -> value.toString()
            10 -> "A"
            11 -> "B"
            12 -> "C"
            else -> "D"
        }

        fun move(direction: Char): RombButton {
            return when (direction) {
                'U' -> newButton(topBorder) { value ->
                    when (value) {
                        3 -> 1
                        6, 7, 8, 10, 11, 12 -> value - 4
                        else -> 11
                    }
                }
                'D' -> newButton(bottomBorder) { value ->
                    when (value) {
                        1 -> 3
                        2, 3, 4, 6, 7, 8 -> value + 4
                        else -> 13
                    }
                }
                'R' -> newButton(rightBorder) { value -> value + 1 }
                else -> newButton(leftBorder) { value -> value - 1 } // L
            }
        }

        private fun newButton(border: List<Int>, valueProvider: (Int) -> Int)
            = if (border.contains(this.value)) this else RombButton(valueProvider(this.value))

    }
}
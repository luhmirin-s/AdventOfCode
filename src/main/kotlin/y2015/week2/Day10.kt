package y2015.week2

import core.AbstractDay

class Day10(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        var line = inputFirstLine
        for (i in 0..39)
            line = transform(line)
        return line.length.toString()
    }

    override fun calculateAdvanced(): String {
        var line = inputFirstLine
        for (i in 0..49)
            line = transform(line)
        return line.length.toString()
    }

    private fun transform(line: String): String {
        val newLine = StringBuilder("")
        var currentChar = line[0]
        var counter = 1

        for (j in 1 until line.length) {
            if (line[j] == currentChar)
                counter++
            else {
                newLine.append(counter).append(currentChar)

                currentChar = line[j]
                counter = 1
            }
        }
        return newLine.append(counter).append(currentChar).toString()
    }
}
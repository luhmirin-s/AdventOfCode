package y2015.week2

import y2015.DayOf2015

class Day10 : DayOf2015("day_10") {

    override fun calculate(): String {
        var line = inputFirstLine()
        for (i in 0..39)
            line = transform(line)
        return line.length.toString()
    }

    override fun calculateAdvanced(): String {
        var line = inputFirstLine()
        for (i in 0..49)
            line = transform(line)
        return line.length.toString()
    }

    private fun transform(line: String): String {
        val newLine = StringBuilder("")
        var currentChar = line[0]
        var counter = 1

        for (j in 1..line.length - 1) {
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
package core

import java.nio.file.Files
import java.nio.file.Paths

abstract class AbstractDay(year: String, fileName: String) {

    private var input: List<String>

    init {
        val path = "inputs/y$year/$fileName.in"

        input = readPathAsLines(path)
    }

    abstract fun calculate(): String

    abstract fun calculateAdvanced(): String

    fun readPathAsLines(path: String): List<String> = javaClass.classLoader
        .getResource(path)
        .toURI()
        .let { Paths.get(it) }
        .let { Files.readAllLines(it) }


    fun input(): List<String> = input

    fun inputFirstLine() = input.first()

    fun inputFirstLineChars() = input.first().toCharArray().asList()
}


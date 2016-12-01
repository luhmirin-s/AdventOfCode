package core

import java.nio.file.Files
import java.nio.file.Paths

abstract class AbstractDay(folderName: String) {

    private var input: List<String>

    init {
        val path = "inputs/$folderName.in"
        input = Files.readAllLines(Paths.get(path))
    }

    abstract fun calculate(): String ;

    abstract fun calculateAdvanced(): String;

    fun input(): List<String> = input

    fun inputFirstLine() = input.first()

    fun inputFirstLineChars() = input.first().toCharArray().asList()

}


package core

import java.nio.file.Files
import java.nio.file.Paths

abstract class AbstractDay {

    private var input: List<String>

    constructor(folderName: String) {
        val path = "inputs/%s.in".format(folderName)
        input = Files.readAllLines(Paths.get(path))

    }

    abstract fun calculate(): String ;

    abstract fun calculateAdvanced(): String;


    fun input(): List<String> {
        return input;
    }

    fun inputFirstLine(): String {
        return input.first()
    }

    fun inputFirstLineChars(): List<Char> {
        return input.first().toCharArray().asList()
    }
}


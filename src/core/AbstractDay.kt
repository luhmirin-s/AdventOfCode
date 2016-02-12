package core

import java.nio.file.Files
import java.nio.file.Paths

abstract class AbstractDay {

    var input: List<String>

    constructor(folderName: String) {
        val path = "inputs/%s/input.in".format(folderName)
        input = Files.readAllLines(Paths.get(path))
    }

    abstract fun calculate(): String ;

    abstract fun calculateAdvanced(): String;
}


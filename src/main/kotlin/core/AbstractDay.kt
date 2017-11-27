package core

abstract class AbstractDay(val input: List<String>) {

    abstract fun calculate(): String

    abstract fun calculateAdvanced(): String


    val inputFirstLine get() = input.first()

    val inputFirstLineChars get() = input.first().toCharArray().asList()
}


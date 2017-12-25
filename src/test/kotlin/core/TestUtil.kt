package core

import java.nio.file.Files
import java.nio.file.Paths

class Dummy()

fun readPathAsLines(path: String): List<String> = Dummy().javaClass.classLoader
    .getResource(path)
    .toURI()
    .let { Paths.get(it) }
    .let { Files.readAllLines(it) }


fun loadLinesForYear(year: Int, day: Int): List<String> =
    "inputs/y$year/day_$day.in".let { readPathAsLines(it) }

fun load2015input(day: Int, cd: (List<String>) -> AbstractDay) =
    loadLinesForYear(2015, day).let(cd)

fun load2016input(day: Int, cd: (List<String>) -> AbstractDay) =
    loadLinesForYear(2016, day).let(cd)

fun load2017input(day: Int, cd: (List<String>) -> AbstractDay) =
    loadLinesForYear(2017, day).let(cd)
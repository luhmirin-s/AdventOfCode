package y2017

import core.AbstractDay
import core.extensions.getInt
import core.extensions.getString
import core.extensions.mapToPattern

class Day7(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.toPrograms().getRoot()

    override fun calculateAdvanced(): String {
        val programs = input.toPrograms()
        val root = programs.getRoot()

        val programsMap = programs.associate { it.name to it.copy() }.toMutableMap()
        replaceWeightsWithSums(programsMap, root)

        val unbalancedProgram = findUnbalancedProgram(programsMap, root)
            ?: throw RuntimeException("something has to be unbalanced")
        val parentOfUnbalanced = programsMap.filterValues { it.links.contains(unbalancedProgram) }.values.firstOrNull()
            ?: throw RuntimeException("It has to have a parent")

        return programs.firstOrNull { it.name == unbalancedProgram }
            ?.let { it.weight - parentOfUnbalanced.getWeightDiff(programsMap) }
            .toString()
    }

    private data class Program(val name: String, var weight: Int, val links: List<String>)

    private fun List<String>.toPrograms() = mapToPattern("(.*)\\s\\((.*)\\)(\\s->\\s(.*))?") {
        Program(
            name = it.getString(1),
            weight = it.getInt(2),
            links = it.getString(4).split(", ")
        )
    }

    private fun List<Program>.getRoot() = flatMap { it.links }.toSet()
        .let { links -> first { !links.contains(it.name) } }
        .name

    private fun replaceWeightsWithSums(programs: MutableMap<String, Program>, root: String) {
        programs[root]?.let {
            val linkedPrograms = it.getLinked(programs)
            linkedPrograms.forEach { replaceWeightsWithSums(programs, it.name) }
            it.weight = it.weight + linkedPrograms.map { it.weight }.sum()
        }
    }

    private fun Program.getLinked(programs: MutableMap<String, Program>) = links.mapNotNull { programs[it] }

    private fun findUnbalancedProgram(programs: MutableMap<String, Program>, root: String): String? {
        val linkedPrograms = programs[root]?.getLinked(programs) ?: emptyList()
        // Cannot be unbalanced, if not balancing anything
        if (linkedPrograms.isEmpty()) return null
        // Find child with unusual weight or just stop
        val unusualChild = linkedPrograms.getChildWithUnusualWeight() ?: return null
        // Find if it is unusual because of it's children
        val unbalancedInChild = findUnbalancedProgram(programs, unusualChild.name)
        return unbalancedInChild ?: unusualChild.name
    }

    private fun List<Program>.getChildWithUnusualWeight() = groupBy { it.weight }.values
        .firstOrNull { it.size == 1 }
        ?.firstOrNull()

    private fun Program.getWeightDiff(programsMap: MutableMap<String, Program>): Int = getLinked(programsMap)
        .groupBy { it.weight }
        .values
        .sortedBy { it.size }
        .map { it.first().weight }
        .let { it.first() - it.last() }

}

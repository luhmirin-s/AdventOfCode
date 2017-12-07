package y2017.week2

import core.AbstractDay

class Day7(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String = input.toPrograms().getRoot()

    override fun calculateAdvanced(): String {
        val programs = input.toPrograms()
        val root = programs.getRoot()

        val programsMap = programs.map { it.name to it.copy() }.toMap().toMutableMap()
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

    private fun List<String>.toPrograms() = mapNotNull {
        Regex("(.*)\\s\\((.*)\\)(\\s->\\s(.*))?").matchEntire(it)?.groups?.let {
            Program(
                name = it[1]?.value ?: "",
                weight = it[2]?.value?.toInt() ?: 0,
                links = it[4]?.value?.split(", ") ?: emptyList()
            )
        }
    }

    private fun List<Program>.getRoot(): String {
        val links = flatMap { it.links }.toSet()
        return first { !links.contains(it.name) }.name
    }

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
        // Find if it is unusual because of itš children
        val unbalancedInChild = findUnbalancedProgram(programs, unusualChild.name)
        return unbalancedInChild ?: unusualChild.name
    }

    // Don't look at this line, pls
    private fun List<Program>.getChildWithUnusualWeight() = groupBy { it.weight }
        .filterValues { it.size == 1 }
        .takeIf { it.isNotEmpty() }
        ?.values
        ?.firstOrNull()
        ?.firstOrNull()

    private fun Program.getWeightDiff(programsMap: MutableMap<String, Program>): Int = getLinked(programsMap)
        .groupBy { it.weight }
        .values
        .sortedBy { it.size }
        .map { it.first().weight }
        .let { it.first() - it.last() }

}

package core.extensions

import java.util.*

/**
 * http://stackoverflow.com/questions/4632322/finding-all-possible-combinations-of-numbers-to-reach-a-given-sum
 */
fun List<Int>.getSumPermutationSet(target: Int): List<List<Int>> = ArrayList<List<Int>>().also {
    sumUpRecursive(it, this, target, ArrayList())
}

private fun sumUpRecursive(results: MutableList<List<Int>>, numbers: List<Int>, target: Int, partial: MutableList<Int>) {
    val sum = partial.sum()

    if (sum == target) results.add(partial)
    if (sum >= target) return

    for (i in 0 until numbers.size) {
        val n = numbers[i]

        val remaining: MutableList<Int> = (i + 1 until numbers.size).mapTo(ArrayList()) { numbers[it] }
        val partialRec = ArrayList(partial)
        partialRec.add(n)

        sumUpRecursive(results, remaining, target, partialRec)
    }
}
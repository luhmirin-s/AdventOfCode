package core.extensions

import java.util.*

/**
 * http://stackoverflow.com/questions/4632322/finding-all-possible-combinations-of-numbers-to-reach-a-given-sum
 */
fun List<Int>.getSumPermutationSet(target: Int): List<List<Int>> {
    var results: MutableList<List<Int>> = ArrayList()

    sumUpRecursive(results, this, target, ArrayList<Int>())

    return results
}

private fun sumUpRecursive(results: MutableList<List<Int>>, numbers: List<Int>, target: Int, partial: MutableList<Int>) {
    var sum = 0
    for (x in partial) sum += x

    if (sum == target) results.add(partial)
    if (sum >= target) return

    for (i in 0..numbers.size - 1) {
        var remaining: MutableList<Int> = ArrayList()
        var n = numbers.get(i)

        for (j in i + 1..numbers.size - 1) remaining.add(numbers.get(j))
        var partial_rec = ArrayList(partial)
        partial_rec.add(n)

        sumUpRecursive(results, remaining, target, partial_rec)
    }
}
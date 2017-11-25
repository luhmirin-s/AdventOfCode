package core.extensions

import java.util.*

fun <T> Set<T>.permutations(): List<List<T>> {
    val initList = this.toList()
    return (0 until initList.size.factorial()).map { permutation(it, initList) }
}

private fun <T> permutation(no: Int, items: List<T>) = permutationHelper(no, LinkedList(items), ArrayList())

private fun <T> permutationHelper(no: Int, input: MutableList<T>, output: MutableList<T>): List<T> {
    if (input.isEmpty()) return output
    val subFactorial = (input.size - 1).factorial()
    output.add(input.removeAt(no / subFactorial))
    return permutationHelper((no % subFactorial), input, output)
}
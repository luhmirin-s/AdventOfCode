package core.extensions

import java.util.*

fun Set<String>.permutations(): List<List<String>> {
    var initList = this.toList()
    return (0..initList.size.factorial() - 1).map { permutation(it, initList) }
}

private fun permutation(no: Int, items: List<String>) = permutationHelper(no, LinkedList(items), ArrayList());

private fun permutationHelper(no: Int, input: MutableList<String>, output: MutableList<String>): List<String> {
    if (input.isEmpty()) return output
    var subFactorial = (input.size - 1).factorial()
    output.add(input.removeAt(no / subFactorial));
    return permutationHelper((no % subFactorial), input, output);
}
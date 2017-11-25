package y2015.week4

import core.extensions.getAllDivisors
import y2015.DayOf2015
import java.util.*

class Day20 : DayOf2015("day_20") {

    override fun calculate(): String {
        val finalValue = inputFirstLine().toInt() / 10
        var houseNumber = 1
        val divisors: MutableSet<Int> = HashSet()

        do {
            houseNumber++
            divisors.clear()
            houseNumber.getAllDivisors(divisors)
        } while (divisors.sum() < finalValue && houseNumber < 1000000)

        return houseNumber.toString()
    }

    override fun calculateAdvanced(): String {
        val finalValue = inputFirstLine().toInt() / 11
        var houseNumber = 0

        val divisors: MutableSet<Int> = HashSet()
        val presentCounter: MutableMap<Int, Int> = HashMap()

        do {
            houseNumber++
            divisors.clear()
            houseNumber.getAllDivisors(divisors)

            divisors.forEach { presentCounter.put(it, presentCounter[it]?.plus(1) ?: 1) }

            val value = divisors.fold(0, { sum, divisor ->
                if (presentCounter[divisor] ?: 0 <= 50) sum + divisor
                else sum
            })

        } while (value < finalValue && houseNumber < 1000000)

        return houseNumber.toString()
    }
}
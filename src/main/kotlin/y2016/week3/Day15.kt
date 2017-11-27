package y2016.week3

import core.AbstractDay

class Day15(input: List<String>) : AbstractDay(input) {

    override fun calculate(): String {
        val disks = input.toDisks()
        return findSuccessPosition(disks).toString()
    }

    override fun calculateAdvanced(): String {
        val originalDisks = input.toDisks().toMutableList()
        originalDisks.add(Disk(11, 0))
        return findSuccessPosition(originalDisks).toString()
    }


    private data class Disk(val total: Int, var current: Int)

    private fun List<String>.toDisks() = this.map { it.split(" ") }
        .map { Disk(it[3].toInt(), it[11].removeSuffix(".").toInt()) }

    private fun List<Disk>.rotateAll(times: Int) = this.forEach { it.current = (it.current + times) % it.total }

    private fun List<Disk>.getDisksAfter(times: Int) = this.map { Disk(it.total, (it.current + times) % it.total) }

    private fun findSuccessPosition(disks: List<Disk>): Int {
        var timer = 0
        var counter = 0

        val ticksToStartPosition = (disks[0].total - disks[0].current - 1)
        disks.rotateAll(ticksToStartPosition)
        timer += ticksToStartPosition

        val pauseBetweenAttempts = disks[0].total

        while (counter < 1000000) {
            val attemptTime = attempt(disks.getDisksAfter(counter * pauseBetweenAttempts))

            if (attemptTime == disks.size) {
                break
            }
            counter++
        }
        timer += (counter * pauseBetweenAttempts)
        return timer
    }

    private fun attempt(disks: List<Disk>): Int {
        for (i in 0..disks.size - 1) {
            disks.rotateAll(1)
            if (disks[i].current != 0) return i
        }
        return disks.size
    }
}
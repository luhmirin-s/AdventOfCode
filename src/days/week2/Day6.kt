package days.week2

import core.AbstractDay

class Day6 : AbstractDay("day_6") {

    override fun calculate(): String {
        var bulbGrid = Grid();

        input().forEach { str ->
            var command = str.toCommand()
            when (command.action) {
                Action.ON -> bulbGrid.turnOn(command.range)
                Action.OFF -> bulbGrid.turnOff(command.range)
                Action.TOGGLE -> bulbGrid.toggle(command.range)
            }
        }
        return bulbGrid.grid.count { it > 0 }.toString()
    }

    override fun calculateAdvanced(): String {
        var bulbGrid = Grid();

        input().forEach { str ->
            var command = str.toCommand()
            when (command.action) {
                Action.ON -> bulbGrid.turnUp(command.range)
                Action.OFF -> bulbGrid.turnDown(command.range)
                Action.TOGGLE -> bulbGrid.turnUpDouble(command.range)
            }
        }
        return bulbGrid.grid.sum().toString()
    }


    enum class Action { ON, OFF, TOGGLE }

    class Grid {

        var grid: Array<Int> = Array(1000 * 1000, { 0 })

        fun turnOn(range: BulbRange): Unit {
            applyToRange(range) { grid[it] = 1 }
        }

        fun turnOff(range: BulbRange): Unit {
            applyToRange(range) { grid[it] = 0 }
        }

        fun toggle(range: BulbRange): Unit {
            applyToRange(range) { if (grid[it] == 1) grid[it] = 0 else grid[it] = 1 }
        }

        fun turnUp(range: BulbRange): Unit {
            applyToRange(range) { grid[it]++ }
        }

        fun turnDown(range: BulbRange): Unit {
            applyToRange(range) { if ( grid[it] > 0 ) grid[it]-- else grid[it] = 0 }
        }

        fun turnUpDouble(range: BulbRange): Unit {
            applyToRange(range) { grid[it] = grid[it] + 2 }
        }

        fun applyToRange(range: BulbRange, func: (index: Int) -> Unit): Unit {
            for (currentY in range.startY..range.endY)
                for (currentX in range.startX..range.endX)
                    func(currentY * 1000 + currentX)
        }
    }


    data class Command(val action: Action, val range: BulbRange)

    fun String.toCommand(): Command {
        if (this.startsWith("toggle")) {
            var range = this.substring(6).toBulbRange()
            return Command(Action.TOGGLE, range)
        } else if (this.startsWith("turn on")) {
            var range = this.substring(7).toBulbRange()
            return Command(Action.ON, range)
        } else {
            var range = this.substring(8).toBulbRange()
            return Command(Action.OFF, range)
        }
    }


    data class BulbRange(val startX: Int, val endX: Int, val startY: Int, val endY: Int)

    fun String.toBulbRange(): BulbRange {
        var items = this.trim().split(' ')
        var start = items[0].split(',').map { s -> s.toInt() }
        var end = items[2].split(',').map { s -> s.toInt() }

        return BulbRange(start[0], end[0], start[1], end[1])
    }

}
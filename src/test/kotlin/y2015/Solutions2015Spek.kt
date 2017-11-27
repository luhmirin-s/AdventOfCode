package y2015

import com.winterbe.expekt.should
import core.load2015input
import core.readPathAsLines
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import y2015.week1.*
import y2015.week2.*
import y2015.week3.*
import y2015.week4.*
import y2015.week5.*

class Solutions2015Spek : Spek({

    given("day 1") {
        val day = load2015input(1) { Day1(it) }

        it("gets star for simple") {
            day.calculate().should.equal("138")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1771")
        }
    }

    given("day 2") {
        val day = load2015input(2) { Day2(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1588178")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("3783758")
        }
    }

    given("day 3") {
        val day = load2015input(3) { Day3(it) }

        it("gets star for simple") {
            day.calculate().should.equal("2592")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("2360")
        }
    }

    given("day 4") {
        val day = load2015input(4) { Day4(it) }

        it("gets star for simple") {
            day.calculate().should.equal("254575")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1038736")
        }
    }

    given("day 5") {
        val day = load2015input(5) { Day5(it) }

        it("gets star for simple") {
            day.calculate().should.equal("255")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("55")
        }
    }

    given("day 6") {
        val day = load2015input(6) { Day6(it) }

        it("gets star for simple") {
            day.calculate().should.equal("377891")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("14110788")
        }
    }

    given("day 7") {
        val day = load2015input(7) { Day7(it) }

        it("gets star for simple") {
            day.calculate().should.equal("3176")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("14710")
        }
    }

    given("day 8") {
        val day = load2015input(8) { Day8(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1371")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("2117")
        }
    }

    given("day 9") {
        val day = load2015input(9) { Day9(it) }

        it("gets star for simple") {
            day.calculate().should.equal("251")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("898")
        }
    }

    given("day 10") {
        val day = load2015input(10) { Day10(it) }

        it("gets star for simple") {
            day.calculate().should.equal("360154")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("5103798")
        }
    }

    given("day 11") {
        val day = load2015input(11) { Day11(it) }

        it("gets star for simple") {
            day.calculate().should.equal("cqjxxyzz")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("cqkaabcc")
        }
    }

    given("day 12") {
        val day = load2015input(12) { Day12(it) }

        it("gets star for simple") {
            day.calculate().should.equal("156366")
        }

        it("gets star for advanced") {
            // It appears that parsing Jsit in pure Kotlin is problematic
            // input file was cleaned up manually (sic!)
            readPathAsLines("inputs/y2015/week3/day_12_2.in")
                .let { Day12(it) }
                .calculateAdvanced()
                .should.equal("96852")
        }
    }

    given("day 13") {
        val day = load2015input(13) { Day13(it) }

        it("gets star for simple") {
            day.calculate().should.equal("733")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("725")
        }
    }

    given("day 14") {
        val day = load2015input(14) { Day14(it) }

        it("gets star for simple") {
            day.calculate().should.equal("2696")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1084")
        }
    }

    given("day 15") {
        val day = load2015input(15) { Day15(it) }

        it("gets star for simple") {
            day.calculate().should.equal("222870")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("117936")
        }
    }

    given("day 16") {
        val day = load2015input(16) { Day16(it) }

        it("gets star for simple") {
            day.calculate().should.equal("40")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("241")
        }
    }

    given("day 17") {
        val day = load2015input(17) { Day17(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1304")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("18")
        }
    }

    given("day 18") {
        val day = load2015input(18) { Day18(it) }

        it("gets star for simple") {
            day.calculate().should.equal("768")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("781")
        }
    }

    given("day 19") {
        val day = load2015input(19) { Day19(it) }

        it("gets star for simple") {
            day.calculate().should.equal("535")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("212")
        }
    }

    given("day 20") {
        val day = load2015input(20) { Day20(it) }

        it("gets star for simple") {
            day.calculate().should.equal("776160")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("786240")
        }
    }

    given("day 21") {
        val day = load2015input(21) { Day21(it) }

        it("gets star for simple") {
            day.calculate().should.equal("121")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("201")
        }
    }

    given("day 22") {
        val day = load2015input(22) { Day22(it) }

        it("gets star for simple") {
            day.calculate().should.equal("900")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1216")
        }
    }

    given("day 23") {
        val day = load2015input(23) { Day23(it) }

        it("gets star for simple") {
            day.calculate().should.equal("255")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("334")
        }
    }

    given("day 24") {
        val day = load2015input(24) { Day24(it) }

        it("gets star for simple") {
            day.calculate().should.equal("11266889531")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("77387711")
        }
    }

    given("day 25") {
        val day = load2015input(25) { Day25(it) }

        it("gets star for simple") {
            day.calculate().should.equal("9132360")
        }
        it("gets star for advanced") {
            true.should.be.`true`
            // this one is for free
        }
    }

})
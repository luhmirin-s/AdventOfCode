package y2017

import com.winterbe.expekt.should
import core.load2017input
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

class Solutions2017Spek : Spek({

    given("day 1") {
        val day = load2017input(1) { Day1(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1203")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1146")
        }
    }

    given("day 2") {
        val day = load2017input(2) { Day2(it) }

        it("gets star for simple") {
            day.calculate().should.equal("47623")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("312")
        }
    }

    given("day 3") {
        val day = load2017input(3) { Day3(it) }

        it("gets star for simple") {
            day.calculate().should.equal("419")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("295229")
        }
    }

    given("day 4") {
        val day = load2017input(4) { Day4(it) }

        it("gets star for simple") {
            day.calculate().should.equal("383")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("265")
        }
    }

    given("day 5") {
        val day = load2017input(5) { Day5(it) }

        it("gets star for simple") {
            day.calculate().should.equal("375042")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("28707598")
        }
    }

    given("day 6") {
        val day = load2017input(6) { Day6(it) }

        it("gets star for simple") {
            day.calculate().should.equal("11137")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1037")
        }
    }

    given("day 7") {
        val day = load2017input(7) { Day7(it) }

        it("gets star for simple") {
            day.calculate().should.equal("eqgvf")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("757")
        }
    }

    given("day 8") {
        val day = load2017input(8) { Day8(it) }

        it("gets star for simple") {
            day.calculate().should.equal("4448")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("6582")
        }
    }

    given("day 9") {
        val day = load2017input(9) { Day9(it) }

        it("gets star for simple") {
            day.calculate().should.equal("11898")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("5601")
        }
    }

    given("day 10") {
        val day = load2017input(10) { Day10(it) }

        it("gets star for simple") {
            day.calculate().should.equal("3770")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("a9d0e68649d0174c8756a59ba21d4dc6")
        }
    }

    given("day 11") {
        val day = load2017input(11) { Day11(it) }

        it("gets star for simple") {
            day.calculate().should.equal("722")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1551")
        }
    }

    given("day 12") {
        val day = load2017input(12) { Day12(it) }

        it("gets star for simple") {
            day.calculate().should.equal("169")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("179")
        }
    }

    given("day 13") {
        val day = load2017input(13) { Day13(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1728")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("3946838")
        }
    }

    given("day 14") {
        val day = load2017input(14) { Day14(it) }

        it("gets star for simple") {
            day.calculate().should.equal("8316")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1074")
        }
    }

    given("day 15") {
        val day = load2017input(15) { Day15(it) }

        it("gets star for simple") {
            day.calculate().should.equal("619")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("290")
        }
    }

    given("day 16") {
        val day = load2017input(16) { Day16(it) }

        it("gets star for simple") {
            day.calculate().should.equal("pkgnhomelfdibjac")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("pogbjfihclkemadn")
        }
    }

    given("day 17") {
        val day = load2017input(17) { Day17(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1971")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("17202899")
        }
    }

    given("day 18") {
        val day = load2017input(18) { Day18(it) }

        it("gets star for simple") {
            day.calculate().should.equal("9423")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("7620")
        }
    }

    given("day 19") {
        val day = load2017input(19) { Day19(it) }

        it("gets star for simple") {
            day.calculate().should.equal("FEZDNIVJWT")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("17200")
        }
    }

    given("day 20") {
        val day = load2017input(20) { Day20(it) }

        it("gets star for simple") {
            day.calculate().should.equal("457")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("448")
        }
    }

    given("day 21") {
        val day = load2017input(21) { Day21(it) }

        it("gets star for simple") {
            day.calculate().should.equal("155")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("2449665")
        }
    }

    given("day 22") {
        val day = load2017input(22) { Day22(it) }

        it("gets star for simple") {
            day.calculate().should.equal("5182")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("2512008")
        }
    }

    given("day 23") {
        val day = load2017input(23) { Day23(it) }

        it("gets star for simple") {
            day.calculate().should.equal("3025")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("915")
        }
    }

    given("day 24") {
        val day = load2017input(24) { Day24(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1940")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1928")
        }
    }

    given("day 25") {
        val day = load2017input(25) { Day25(it) }

        it("gets star for simple") {
            day.calculate().should.equal("2794")
        }
        it("gets star for advanced") {
            true.should.be.`true`
            // this ite is for free
        }
    }
})
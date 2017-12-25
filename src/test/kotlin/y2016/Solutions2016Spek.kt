package y2016

import com.winterbe.expekt.should
import core.load2016input
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

class Solutions2016Spek : Spek({

    given("day 1") {
        val day = load2016input(1) { Day1(it) }

        it("gets star for simple") {
            day.calculate().should.equal("252")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("143")
        }
    }

    given("day 2") {
        val day = load2016input(2) { Day2(it) }

        it("gets star for simple") {
            day.calculate().should.equal("78293")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("AC8C8")
        }
    }

    given("day 3") {
        val day = load2016input(3) { Day3(it) }

        it("gets star for simple") {
            day.calculate().should.equal("869")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1544")
        }
    }

    given("day 4") {
        val day = load2016input(4) { Day4(it) }

        it("gets star for simple") {
            day.calculate().should.equal("361724")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("482")
        }
    }

    given("day 5") {
        val day = load2016input(5) { Day5(it) }

        it("gets star for simple") {
            day.calculate().should.equal("f77a0e6e")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("999828ec")
        }
    }

    given("day 6") {
        val day = load2016input(6) { Day6(it) }

        it("gets star for simple") {
            day.calculate().should.equal("kqsdmzft")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("tpooccyo")
        }
    }

    given("day 7") {
        val day = load2016input(7) { Day7(it) }

        it("gets star for simple") {
            day.calculate().should.equal("110")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("242")
        }
    }

    given("day 8") {
        val day = load2016input(8) { Day8(it) }

        it("gets star for simple") {
            day.calculate().should.equal("128")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("-1")
        }
    }

    given("day 9") {
        val day = load2016input(9) { Day9(it) }

        it("gets star for simple") {
            day.calculate().should.equal("107035")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("11451628995")
        }
    }

    given("day 10") {
        val day = load2016input(10) { Day10(it) }

        it("gets star for simple") {
            day.calculate().should.equal("27")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("13727")
        }
    }

    given("day 11") {
        val day = load2016input(11) { Day11(it) }

        it("gets star for simple") {
            day.calculate().should.equal("31")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("55")
        }
    }

    given("day 12") {
        val day = load2016input(12) { Day12(it) }

        it("gets star for simple") {
            day.calculate().should.equal("318077")
        }

        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("9227731")
        }
    }

    given("day 13") {
        val day = load2016input(13) { Day13(it) }

        it("gets star for simple") {
            day.calculate().should.equal("86")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("127")
        }
    }

    given("day 14") {
        val day = load2016input(14) { Day14(it) }

        it("gets star for simple") {
            day.calculate().should.equal("15168")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("20864")
        }
    }

    given("day 15") {
        val day = load2016input(15) { Day15(it) }

        it("gets star for simple") {
            day.calculate().should.equal("203660")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("2408135")
        }
    }

    given("day 16") {
        val day = load2016input(16) { Day16(it) }

        it("gets star for simple") {
            day.calculate().should.equal("11100111011101111")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("10001110010000110")
        }
    }

    given("day 17") {
        val day = load2016input(17) { Day17(it) }

        it("gets star for simple") {
            day.calculate().should.equal("RDRDUDLRDR")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("386")
        }
    }

    given("day 18") {
        val day = load2016input(18) { Day18(it) }

        it("gets star for simple") {
            day.calculate().should.equal("2013")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("20006289")
        }
    }

    given("day 19") {
        val day = load2016input(19) { Day19(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1834471")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1420064")
        }
    }

    given("day 20") {
        val day = load2016input(20) { Day20(it) }

        it("gets star for simple") {
            day.calculate().should.equal("4793564")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("146")
        }
    }

    given("day 21") {
        val day = load2016input(21) { Day21(it) }

        it("gets star for simple") {
            day.calculate().should.equal("bgfacdeh")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("bdgheacf")
        }
    }

    given("day 22") {
        val day = load2016input(22) { Day22(it) }

        it("gets star for simple") {
            day.calculate().should.equal("910")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("222")
        }
    }

    given("day 23") {
        val day = load2016input(23) { Day23(it) }

        it("gets star for simple") {
            day.calculate().should.equal("10890")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("479007450")
        }
    }

    given("day 24") {
        val day = load2016input(24) { Day24(it) }

        it("gets star for simple") {
            day.calculate().should.equal("412")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("664")
        }
    }

    given("day 25") {
        val day = load2016input(25) { Day25(it) }

        it("gets star for simple") {
            day.calculate().should.equal("189")
        }
        it("gets star for advanced") {
            true.should.be.`true`
            // this ite is for free
        }
    }

})
package y2017

import com.winterbe.expekt.should
import core.load2017input
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import y2017.week1.*
import y2017.week2.*
import y2017.week3.Day11
import y2017.week3.Day12
import y2017.week3.Day13

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
})
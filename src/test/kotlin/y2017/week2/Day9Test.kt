package y2017.week2

internal class Day9Test {

    // THis might be useful if some more dubuging is needed. Just uncomment tests and make functions in Day9 public

//    @Test
//    fun countGarbage() {
//        "<>".toCharList().removeNots().countGarbage().should.equal(0)
//        "<random characters>".toCharList().removeNots().countGarbage().should.equal(17)
//        "<<<<>".toCharList().removeNots().countGarbage().should.equal(3)
//        "<{!>}>".toCharList().removeNots().countGarbage().should.equal(2)
//        "<!!>".toCharList().removeNots().countGarbage().should.equal(0)
//        "<!!!>>".toCharList().removeNots().countGarbage().should.equal(0)
//        "<{o\"i!a,<{i<a>".toCharList().removeNots().countGarbage().should.equal(10)
//    }
//
//    @Test
//    fun scoring() {
//        "{}".toCharList().removeNots().removeGarbage().getScore().should.equal(1)
//        "{{{}}}".toCharList().removeNots().removeGarbage().getScore().should.equal(6)
//        "{{},{}}".toCharList().removeNots().removeGarbage().getScore().should.equal(5)
//        "{{{},{},{{}}}}".toCharList().removeNots().removeGarbage().getScore().should.equal(16)
//        "{<a>,<a>,<a>,<a>}".toCharList().removeNots().removeGarbage().getScore().should.equal(1)
//        "{{<ab>},{<ab>},{<ab>},{<ab>}}".toCharList().removeNots().removeGarbage().getScore().should.equal(9)
//        "{{<!!>},{<!!>},{<!!>},{<!!>}}".toCharList().removeNots().removeGarbage().getScore().should.equal(9)
//    }
//
//    @Test
//    fun removingNots() {
//        "<{!>}>".toCharList().removeNots().should.equal("<{}>".toCharList())
//        "<{o\"i!a,<{i<a>".toCharList().removeNots().should.equal("<{o\"i,<{i<a>".toCharList())
//        "<!!!>>".toCharList().removeNots().should.equal("<>".toCharList())
//        "{{<!>},{<!>},{<!>},{<a>}}".toCharList().removeNots().should.equal("{{<},{<},{<},{<a>}}".toCharList())
//        "{{<!!>},{<!!>},{<!!>},{<!!>}}".toCharList().removeNots().should.equal("{{<>},{<>},{<>},{<>}}".toCharList())
//    }
//
//    @Test
//    fun removingGarbage() {
//        "<>".toCharList().removeNots().removeGarbage().should.equal("".toCharList())
//        "<random characters>".toCharList().removeNots().removeGarbage().should.equal("".toCharList())
//        "<<<<>".toCharList().removeNots().removeGarbage().should.equal("".toCharList())
//        "<{!>}>".toCharList().removeNots().removeGarbage().should.equal("".toCharList())
//        "<!!>".toCharList().removeNots().removeGarbage().should.equal("".toCharList())
//        "<!!!>>".toCharList().removeNots().removeGarbage().should.equal("".toCharList())
//        "<{o\"i!a,<{i<a>".toCharList().removeNots().removeGarbage().should.equal("".toCharList())
//        "{<{},{},{{}}>}".toCharList().removeNots().removeGarbage().should.equal("{}".toCharList())
//        "{<a>,<a>,<a>,<a>}" .toCharList().removeNots().removeGarbage().should.equal("{}".toCharList())
//        "{{<ab>},{<ab>},{<ab>},{<ab>}}".toCharList().removeNots().removeGarbage().should.equal("{{}{}{}{}}".toCharList())
//    }
}
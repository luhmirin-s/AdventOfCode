package core.extensions

import com.winterbe.expekt.should
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CharsTest {

    @Test
    fun toIntValue() {
        '0'.toIntValue().should.equal(0)
        '1'.toIntValue().should.equal(1)
        '2'.toIntValue().should.equal(2)
        '3'.toIntValue().should.equal(3)
        '4'.toIntValue().should.equal(4)
        '5'.toIntValue().should.equal(5)
        '6'.toIntValue().should.equal(6)
        '7'.toIntValue().should.equal(7)
        '8'.toIntValue().should.equal(8)
        '9'.toIntValue().should.equal(9)
    }
}
package core.extensions

import org.junit.Assert.*
import org.junit.Test

class IntsTest {

    @Test
    fun testIsOdd() {
        assertFalse(4.isOdd())
        assertTrue(5.isOdd())
    }

    @Test
    fun testToBinary() {
        assertEquals("1", 1.toBinary())
        assertEquals("10", 2.toBinary())
        assertEquals("10101", 21.toBinary())
        assertEquals("11111110", 254.toBinary())
        assertEquals("1111111111111111", 65535.toBinary())
    }

    @Test
    fun testFactorial() {
        assertEquals(1, 0.factorial())
        assertEquals(1, 1.factorial())
        assertEquals(2, 2.factorial())
        assertEquals(6, 3.factorial())
        assertEquals(24, 4.factorial())
        assertEquals(120, 5.factorial())
    }

}
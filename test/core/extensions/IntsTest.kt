package core.extensions

import org.junit.Assert.*
import org.junit.Test
import java.util.*

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

    @Test
    fun testIntegerSqrt() {
        assertEquals(1, 1.integerSqrt())
        assertEquals(1, 2.integerSqrt())
        assertEquals(2, 4.integerSqrt())
        assertEquals(3, 9.integerSqrt())
        assertEquals(3, 10.integerSqrt())
        assertEquals(4, 15.integerSqrt())
    }

    @Test
    fun testGetAllDivisors() {
        var testSet: MutableSet<Int> = HashSet()
        1.getAllDivisors(testSet)
        assertEquals(setOf(1), testSet)

        testSet.clear()
        3.getAllDivisors(testSet)
        assertEquals(setOf(1, 3), testSet)

        testSet.clear()
        8.getAllDivisors(testSet)
        assertEquals(setOf(1, 2, 4, 8), testSet)

        testSet.clear()
        9.getAllDivisors(testSet)
        assertEquals(setOf(1, 3, 9), testSet)
    }

}
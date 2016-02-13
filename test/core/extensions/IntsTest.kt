package core.extensions

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class IntsTest {

    @Test
    fun testIsOdd() {
        assertFalse(4.isOdd())
        assertTrue(5.isOdd())
    }
}
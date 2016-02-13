package core.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class StringsTest {

    @Test
    fun testMd5() {
        assertEquals("000001dbbfa", "abcdef609043".md5Hex().substring(0..10))
        assertEquals("000006136ef", "pqrstuv1048970".md5Hex().substring(0..10))
    }

    @Test
    fun testAddLeadingZeros() {
        assertEquals("0003a34", "3a34".addLeadingZeros(maxLength = 7))
        assertEquals("aaa3a34", "aaa3a34".addLeadingZeros(maxLength = 7))
    }

}
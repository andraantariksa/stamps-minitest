import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ApaBoleTest {
    @Test
    fun `multiplies of 15 should return ApaBole`() {
        for (i in 1..10) {
            assertEquals("ApaBole", apaBole(i * 15))
        }
    }

    @Test
    fun `multiplies of 3 and not multiplies of 5 should return ApaBole`() {
        for (i in 1..10) {
            val j = i * 3
            if (j % 5 == 0) continue
            assertEquals("Apa", apaBole(j))
        }
    }

    @Test
    fun `multiplies of 5 and not multiplies of 3 should return ApaBole`() {
        for (i in 1..10) {
            val j = i * 5
            if (j % 3 == 0) continue
            assertEquals("Bole", apaBole(j))
        }
    }

    @Test
    fun `should match on predefined result`() {
        assertEquals(
            "1, 2, Apa, 4, Bole, Apa, 7, 8, Apa, Bole, 11, Apa, 13, 14, ApaBole, 16, 17, Apa, 19, Bole, Apa, 22, 23, Apa, Bole, 26, Apa, 28, 29, ApaBole\n",
            apaBoleAccumulator(30)
        )
    }

    @Test
    fun `should return '1' for n = 1`() {
        assertEquals("1\n", apaBoleAccumulator(1))
    }

    @Test
    fun `should be empty when n is 0`() {
        assertEquals("\n", apaBoleAccumulator(0))
    }
}
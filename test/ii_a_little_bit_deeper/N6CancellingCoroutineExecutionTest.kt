package ii_a_little_bit_deeper

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.experimental.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

// mock log functionality in next test
class N6CancellingCoroutineExecutionTest {
    val out: ByteArrayOutputStream = ByteArrayOutputStream()

    @Before fun setUpOutputStream() = System.setOut(PrintStream(out))

    @Test fun testJobCancellation() = runBlocking {
        _n6_cancelling_corourine()
        assertEquals(""".
.
Job cancelled!
""", out.toString())
    }

    @After fun restoreOutputStream() = System.setOut(System.out)
}
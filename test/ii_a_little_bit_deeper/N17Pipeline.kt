package ii_a_little_bit_deeper

import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

class N17Pipeline {
    @Test
    fun testPipeline() = runBlocking<Unit> {
        val numGenerator = _17_num_generator()
        val squareGenerator = _17_num_squarer(numGenerator)

        val array = ArrayList<Int>()
        for (x in 1..5) {
            array.add(squareGenerator.receive())
        }
        numGenerator.cancel()
        squareGenerator.cancel()

        assertTrue(1 in array)
        assertTrue(4 in array)
        assertTrue(9 in array)
        assertTrue(16 in array)
        assertTrue(25 in array)
    }
}
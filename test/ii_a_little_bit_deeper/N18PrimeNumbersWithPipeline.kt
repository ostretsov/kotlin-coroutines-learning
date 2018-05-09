package ii_a_little_bit_deeper

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.experimental.cancelChildren
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

class N18PrimeNumbersWithPipeline {
    @Test
    fun testPrimeNumbersPipeline() = runBlocking {
        val primeNumbersPipeline = primeNumbers(coroutineContext)
        val primes = arrayListOf<Int>()
        for (i in 1..10) {
            val n = primeNumbersPipeline.receive()
            primes.add(n)
        }
        coroutineContext.cancelChildren()

        assertEquals(arrayListOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), primes)
    }
}
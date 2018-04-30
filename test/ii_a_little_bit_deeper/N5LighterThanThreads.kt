package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.runBlocking
import measureMemoryBytes
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.system.measureTimeMillis

class N5LighterThanThreads {
    @Test fun coroutinesFaster() = runBlocking {
        val threadsTakes = measureTimeMillis {
            _n5_delayInThreads()
        }

        val coroutinesTakes = measureTimeMillis {
            _n5_delayInCoroutines()
        }

        assertTrue("Coroutines faster than threads", coroutinesTakes < threadsTakes)
    }

    @Test fun coroutinesConsumeLessMemory() = runBlocking {
        val threadsTakes = measureMemoryBytes {
            _n5_delayInThreads()
        }

        val coroutinesTakes = measureMemoryBytes {
            _n5_delayInCoroutines()
        }

        assertTrue("Coroutines consume less memory: ${coroutinesTakes}b (coroutines) < ${threadsTakes}b (threads)", coroutinesTakes < threadsTakes)
    }
}
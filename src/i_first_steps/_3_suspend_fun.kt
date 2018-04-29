package i_first_steps

import kotlinx.coroutines.experimental.*

suspend fun workload(n: Int): Int {
    delay(1000)
    return n
}

fun main(args: Array<String>) {
    val deferredItems = (1..1_000_000).map { async { workload(it) } }
    runBlocking {
        println(deferredItems.sumBy { it.await() })
    }
}
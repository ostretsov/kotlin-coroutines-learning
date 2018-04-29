package i_first_steps

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) {
    val defferedItems = (1..1_000_000).map {
        async {
            delay(1000)
            it
        }
    }
    runBlocking {
        println(defferedItems.sumBy { it.await() })
    }
}
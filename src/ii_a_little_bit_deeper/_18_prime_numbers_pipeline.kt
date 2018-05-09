package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlin.coroutines.experimental.CoroutineContext

fun primeNumbers(context: CoroutineContext) = produce<Int> {
    var primeNumbers = numbers(context,2)
    while (true) {
        val nextPrime = primeNumbers.receive()
        send(nextPrime)
        primeNumbers = filter(context, primeNumbers, nextPrime)
    }
}

fun numbers(context: CoroutineContext, start: Int) = produce<Int>(context) {
    var x = start
    while(true) {
        send(x++)
    }
}

fun filter(context: CoroutineContext, input: ReceiveChannel<Int>, filter: Int) = produce<Int> {
    for (nextNum in input) {
        if (nextNum % filter != 0) send(nextNum)
    }
}
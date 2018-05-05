package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.delay

fun _17_num_generator() = produce<Int> {
    var i = 0
    while (true) {
        delay(100)
        send(++i)
    }
}

fun _17_num_squarer(numbers: ReceiveChannel<Int>) = produce<Int> {
    for (n in numbers) {
        delay(100)
        send(n * n)
    }
}
package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.delay

suspend fun justDelay500(): String {
    delay(500)


    return "Done!"
}
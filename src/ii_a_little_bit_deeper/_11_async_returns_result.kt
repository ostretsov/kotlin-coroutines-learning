package ii_a_little_bit_deeper

import kotlinx.coroutines.experimental.delay

suspend fun _11_calcSthImportant1(): Int {
    delay(500)
    return 42
}

suspend fun _11_calcSthImportant2(): Int {
    delay(500)
    return 108
}
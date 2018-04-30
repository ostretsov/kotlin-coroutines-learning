inline fun measureMemoryBytes(block: () -> Unit): Long {
    val runtime = Runtime.getRuntime()
    val freeMemoryBefore = runtime.freeMemory()
    block()

    return freeMemoryBefore - runtime.freeMemory()
}
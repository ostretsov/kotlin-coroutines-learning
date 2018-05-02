interface Logger {
    fun log(message: String): Unit
    fun logln(message: String): Unit
}

class ConsoleLogger : Logger {
    override fun log(message: String) = System.out.print(message)
    override fun logln(message: String) = System.out.println(message)
}

class StringBufferLogger(): Logger {
    val buffer: StringBuffer = StringBuffer()

    override fun log(message: String) {
        buffer.append(message)
    }
    override fun logln(message: String) {
        buffer.appendln(message)
    }
}
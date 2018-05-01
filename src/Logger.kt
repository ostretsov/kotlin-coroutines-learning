interface Logger {
    fun log(message: String): Unit

}

class ConsoleLogger : Logger {
    override fun log(message: String) = System.out.println(message)
}

class StringBufferLogger(): Logger {
    val buffer: StringBuffer = StringBuffer()

    override fun log(message: String) {
        buffer.append(message)
    }
}
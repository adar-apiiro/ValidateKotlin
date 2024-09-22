// Install dependencies in Gradle
// implementation("com.microsoft.thrifty:thrifty-runtime:3.0.0")

import com.microsoft.thrifty.server.Server
import com.microsoft.thrifty.protocol.BinaryProtocol
import com.microsoft.thrifty.transport.ServerSocketTransport

class CalculatorServiceImpl : CalculatorService {
    override fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

// Start the Thrift server
fun main() {
    val transport = ServerSocketTransport(9090)
    val protocolFactory = { BinaryProtocol(transport) }
    val server = Server(transport, protocolFactory) {
        registerService(CalculatorServiceImpl())
    }

    server.serve()
    println("Thrift server running on port 9090")
}

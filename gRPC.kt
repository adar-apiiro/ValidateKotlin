// Install dependencies in Gradle
// implementation("io.grpc:grpc-kotlin-stub:1.1.0")
// implementation("io.grpc:grpc-netty:1.39.0")

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import com.example.grpc.CalculatorServiceGrpc
import com.example.grpc.AddRequest
import com.example.grpc.AddResponse

// Implement the service
class CalculatorServiceImpl : CalculatorServiceGrpc.CalculatorServiceImplBase() {
    override fun add(request: AddRequest, responseObserver: StreamObserver<AddResponse>) {
        val result = request.num1 + request.num2
        val response = AddResponse.newBuilder().setResult(result).build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}

// Start the gRPC server
fun main() {
    val server: Server = ServerBuilder
        .forPort(50051)
        .addService(CalculatorServiceImpl())
        .build()

    server.start()
    println("Server started on port 50051")
    server.awaitTermination()
}

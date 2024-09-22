// Install dependencies in Gradle
// implementation("jakarta.xml.ws:jakarta.xml.ws-api:2.3.3")

import jakarta.jws.WebMethod
import jakarta.jws.WebService
import jakarta.xml.ws.Endpoint

@WebService
class CalculatorService {

    @WebMethod
    fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

fun main() {
    val service = CalculatorService()
    Endpoint.publish("http://localhost:8080/CalculatorService", service)
    println("SOAP Web Service running at http://localhost:8080/CalculatorService?wsdl")
}

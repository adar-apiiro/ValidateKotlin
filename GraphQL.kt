// Install dependencies in Gradle
// implementation("com.expediagroup:graphql-kotlin-spring-server:5.0.0")

import com.expediagroup.graphql.server.operations.Query
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

// Define the query
class HelloWorldQuery : Query {
    fun helloWorld(): String = "Hello, GraphQL!"
}

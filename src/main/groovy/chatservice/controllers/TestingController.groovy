package chatservice.controllers

import chatservice.client.ChatClientWebSocketClient
import chatservice.services.ChatTableWatcher
import io.micronaut.context.annotation.Requires
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import io.micronaut.websocket.RxWebSocketClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Inject

@Controller("/chattest")
@Requires(beans=ChatTableWatcher)
class TestingController {

    Logger log = LoggerFactory.getLogger(TestingController)

    @Inject
    @Client("http://localhost:8080")
    RxWebSocketClient userWebSocketClient

    @Get
    String index() {
        "This is the chat testing controller"
    }

    @Get("/{sender}")
    String sendMessage(String sender, @QueryValue String message)
    {
        log.info "Handling demo message sending"
        ChatClientWebSocketClient client = userWebSocketClient.connect(ChatClientWebSocketClient, "/chat/$sender/").blockingFirst()
        client.send(message)
        "Sent."
    }
}

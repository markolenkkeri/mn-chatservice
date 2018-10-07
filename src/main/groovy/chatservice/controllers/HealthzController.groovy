package chatservice.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/healthz")
class HealthzController {

    @Get
    String healthz() {
        "A-okay"
    }
}


package com.raihanorium.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class HomeController {

    @Get(produces = "text/plain")
    public String index() {
        log.info("Home controller called");
        return "Hello, Micronaut!";
    }
}

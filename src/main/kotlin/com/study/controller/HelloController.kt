package com.study.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import net.logstash.logback.argument.StructuredArguments.kv
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Controller("/hello")
class HelloController constructor() {

    var logger: Logger = LoggerFactory.getLogger(HelloController::class.java)

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String? {
        logger.info("Request Hello Api Received", kv("myCustom", "Ola"), kv("outra", "coisa"))
        return "Hello"
    }
}
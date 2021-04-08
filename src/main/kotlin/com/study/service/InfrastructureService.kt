package com.study.service

import io.micronaut.context.annotation.Infrastructure
import java.util.*
import javax.annotation.PostConstruct

@Infrastructure
open class InfrastructureServiceBean {

    private lateinit var value: String

    @PostConstruct
    fun init() {
        value = UUID.randomUUID().toString()
    }

    open fun getValue(): String {
        return value
    }
}
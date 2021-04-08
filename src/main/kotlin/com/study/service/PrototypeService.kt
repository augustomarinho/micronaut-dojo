package com.study.service

import io.micronaut.context.annotation.Prototype
import java.util.*
import javax.annotation.PostConstruct

@Prototype
class PrototypeServiceImpl: PrototypeService {

    private lateinit var value: String

    @PostConstruct
    fun init() {
        value = UUID.randomUUID().toString()
    }

    override fun getValue(): String {
        return value
    }
}

interface PrototypeService {
    fun getValue(): String
}
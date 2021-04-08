package com.study.service

import io.micronaut.runtime.context.scope.Refreshable
import java.util.*
import javax.annotation.PostConstruct

@Refreshable
class RefreshableServiceImpl : RefreshableService {

    private lateinit var value: String

    @PostConstruct
    fun init() {
        value = UUID.randomUUID().toString()
    }

    override fun getValue(): String {
        return value
    }
}

interface RefreshableService {
    fun getValue(): String
}
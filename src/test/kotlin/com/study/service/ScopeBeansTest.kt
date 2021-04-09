package com.study.service

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class ScopeBeansTest {

    @Inject
    private lateinit var service1: PrototypeService

    @Inject
    private lateinit var service2: PrototypeService

    @Inject
    private lateinit var service3: SingletonService

    @Inject
    private lateinit var service4: SingletonService

    @Test
    fun testDifferentInstances() {
        println("Service1: ${service1.getValue()}\tService2:${service2.getValue()}")
        assertNotEquals(service1.getValue(), service2.getValue())

        println("Service3: ${service3.getValue()}\tService4:${service4.getValue()}")
        assertEquals(service3.getValue(), service4.getValue())
    }
}
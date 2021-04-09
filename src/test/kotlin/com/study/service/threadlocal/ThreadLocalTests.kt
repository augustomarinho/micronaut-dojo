package com.study.service.threadlocal

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Executors
import javax.inject.Inject


@MicronautTest
class ThreadLocalTests {

    @Inject
    private lateinit var begin: BeginService

    @Inject
    private lateinit var finish: FinishService


    @Test
    fun testThreadLocalScope() {
        val r = Random()
        val executor = Executors.newFixedThreadPool(10)
        for (i in 0..19) {
            executor.execute {
                val correlationId = "abc" + r.nextInt(10000)
                begin.start(correlationId)
                Assertions.assertEquals(correlationId, finish.finish())
            }
        }
        executor.shutdown()
        while (!executor.isTerminated) {
        }
        println("Finished all threads")
    }
}
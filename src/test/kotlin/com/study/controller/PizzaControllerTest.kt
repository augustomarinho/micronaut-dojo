package com.study.controller

import com.nhaarman.mockitokotlin2.any
import com.study.domain.Pizza
import com.study.service.PizzaService
import com.study.service.PizzaServiceImpl
import com.study.service.app.dto.PizzaRequest
import com.study.service.app.dto.PizzaResponse
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest(environments = ["test"])
class PizzaControllerTest {

    @Inject
    @field:Client("/")
    lateinit var httpClient: RxHttpClient

    @Inject
    lateinit var pizzaServiceMock: PizzaService

    @MockBean(PizzaService::class)
    fun myService(): PizzaService {
        return Mockito.mock(PizzaServiceImpl::class.java)
    }

    @Test
    fun testCreateOrderWithSuccess() {
        val pizza = Pizza(1, "abacaxi")
        Mockito.`when`(pizzaServiceMock.createOrder(any())).thenReturn(pizza)

        var request: HttpRequest<PizzaRequest> = HttpRequest.POST("/pizza/order", PizzaRequest("abacaxi"))
                .contentType(
                        MediaType.APPLICATION_JSON
                )

        val response: HttpResponse<PizzaResponse> = httpClient.toBlocking().exchange(request, PizzaResponse::class.java)

        Assertions.assertNotNull(response)
        Assertions.assertEquals(response.status, HttpStatus.CREATED)
        Assertions.assertEquals(response.body()?.getFlavor(), pizza.getFlavor())
        Assertions.assertEquals(response.body()?.getOrderId(), pizza.getOrderId())
    }
}
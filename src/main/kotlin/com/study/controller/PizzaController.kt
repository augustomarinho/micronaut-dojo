package com.study.controller

import com.study.service.PizzaService
import com.study.service.app.dto.PizzaRequest
import com.study.service.app.dto.PizzaResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/pizza")
class PizzaController @Inject constructor(private val pizzaService: PizzaService) {

    @Post("/order")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createOrder(@Body pizzaRequest: PizzaRequest) : HttpResponse<PizzaResponse>{
        val pizza = pizzaService.createOrder(pizzaRequest.getFlavor())
        return HttpResponse.created(PizzaResponse.from(pizza))
    }

    @Get("/order/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getOrder(@PathVariable orderId : Int) : PizzaResponse{
        val pizza = pizzaService.getOrder(orderId)
        return PizzaResponse.from(pizza)
    }
}

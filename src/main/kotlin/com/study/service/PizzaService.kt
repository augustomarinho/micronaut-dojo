package com.study.service

import com.study.domain.Pizza
import javax.annotation.PostConstruct
import javax.inject.Singleton

@Singleton
class PizzaServiceImpl : PizzaService {
    private lateinit var orderMap: MutableMap<Int, Pizza>

    @PostConstruct
    private fun init() {
        orderMap = HashMap<Int, Pizza>()
    }

     override fun getOrder(orderId: Int): Pizza {
        return orderMap.getOrDefault(orderId, Pizza(0, "NADA"))
    }

     override fun createOrder(flavor: String): Pizza {
        val orderId = orderMap.size + 1
        val pizza = Pizza(orderId, flavor)
        orderMap[orderId] = pizza
        return pizza
    }
}

interface PizzaService {
    fun getOrder(orderId : Int) : Pizza
    fun createOrder(flavor : String) : Pizza

}
package com.anythum.grocerydelivery.utils

import com.anythum.grocerydelivery.model.CartItem

object CartManager {

    val cartItems = mutableListOf<CartItem>()

    fun addItem(item: CartItem) {

        val existingItem =
            cartItems.find { it.name == item.name }

        if (existingItem != null) {

            existingItem.quantity++

        } else {

            cartItems.add(item)
        }
    }
}
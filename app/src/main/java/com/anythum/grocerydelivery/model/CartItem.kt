package com.anythum.grocerydelivery.model

data class CartItem(

    val name: String,

    val price: Int,

    val image: Int,

    var quantity: Int = 1
)
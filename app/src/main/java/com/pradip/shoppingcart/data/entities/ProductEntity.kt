package com.pradip.shoppingcart.data.entities


data class ProductEntity(
    val product_image : String,
    val product_title : String,
    val required_qty : Int,
    val pickup_qty : Int
)


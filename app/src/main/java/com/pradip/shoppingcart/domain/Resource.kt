package com.pradip.shoppingcart.domain

sealed interface Resource < out T> {
    class Success<out T>(val value :  T) : Resource<T>
    object Loading : Resource<Nothing>
    class Error(val code : Int? = null, val reason : String ? = "") : Resource<Nothing>
}
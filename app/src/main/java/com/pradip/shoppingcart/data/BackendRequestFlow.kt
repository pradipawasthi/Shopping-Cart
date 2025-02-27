package com.pradip.shoppingcart.data

import com.pradip.shoppingcart.domain.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

fun <T> backendRequestFlow(request: suspend () -> T) : Flow<Resource<T>> = flow {
    emit(Resource.Loading)
    emit(Resource.Success(request))
}

suspend fun <T> backendRequestFlow(request: suspend () -> T) : Resource<T>{
    withContext(Dispatchers.IO){
        try {
            Resource.Success(request.invoke())
        }
        catch (e : Exception){
            Resource.Error(500, e.message)
        }
    }
}
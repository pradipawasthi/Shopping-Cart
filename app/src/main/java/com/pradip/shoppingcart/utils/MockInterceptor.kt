package com.pradip.shoppingcart.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import java.net.URI

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var response: Response? = null
//        if (BuildConfig.DEBUG) {
            // Get Request URI.
            val uri: URI = chain.request().url.toUri()
            // Get path String.
            var path: String = uri.path
            // Remove the starter slide '/'
            path = "mock_product_list"
            // Get the json file text
            val responseString: String = getJsonDataFromAsset(path).orEmpty()

            // Create the response
            response = Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create("application/json".toMediaType(), responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
//        } else {
//            response = chain.proceed(chain.request())
//        }
        return response
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            // Append the json extension
            jsonString = context.assets.open("$fileName.json").bufferedReader().use { it.readText() }
        } catch (exception: Exception) {
            exception.printStackTrace()
            return null
        }
        return jsonString
    }

}
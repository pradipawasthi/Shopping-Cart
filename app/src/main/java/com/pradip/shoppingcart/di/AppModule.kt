package com.pradip.shoppingcart.di

import android.content.Context
import com.pradip.shoppingcart.data.repository.ProductListRepositoryImpl
import com.pradip.shoppingcart.data.services.ProductService
import com.pradip.shoppingcart.domain.repository.ProductListRepository
import com.pradip.shoppingcart.utils.MockInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides fun provideContext(@ApplicationContext context: Context,): Context {    return context}

    @Provides
    @Singleton
    fun getOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(MockInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)

        return httpBuilder
            .protocols(mutableListOf(Protocol.HTTP_1_1))
            .build()
    }


    @Provides
    fun provideBaseUrl(): String = "https://youtube.googleapis.com/youtube/v3/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideProductService(retrofit: Retrofit): ProductService= retrofit.create(ProductService::class.java)


    @Provides
    @Singleton
    fun provideProductListRepository(productService: ProductService) : ProductListRepository {
        return  ProductListRepositoryImpl(productService)
    }

}
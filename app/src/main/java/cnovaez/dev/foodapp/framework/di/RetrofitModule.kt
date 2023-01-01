package cnovaez.dev.foodapp.framework.di

import cnovaez.dev.foodapp.data.network.RetrofitAPI
import cnovaez.dev.foodapp.utils.GlobalValues
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 ** Created by Carlos A. Novaez Guerrero on 31/12/2022 6:33
 ** cnovaez.dev@outlook.com
 **/

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
     return  Retrofit.Builder()
            .baseUrl(GlobalValues.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): RetrofitAPI {
        return retrofit.create(RetrofitAPI::class.java)
    }
}
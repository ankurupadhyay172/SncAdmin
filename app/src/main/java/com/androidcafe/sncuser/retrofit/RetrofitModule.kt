package com.androidcafe.sncuser.retrofit

import com.androidcafe.sncuser.BuildConfig
import com.androidcafe.sncuser.ui.beforestart.api.AuthApiService
import com.androidcafe.sncuser.ui.home.api.HomeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun providesBaseUrl():String = BuildConfig.BASE_URL


    //create logger
    val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //create okhttp client
    val okhttp  = OkHttpClient.Builder().addInterceptor(logger)


    @Provides
    @Singleton
    fun providesRetrofitBuilder(baseurl:String): Retrofit = Retrofit.Builder().baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create()).client(okhttp.build())
        .build()



    @Provides
    fun providesPostApiService(retrofit: Retrofit): AuthApiService = retrofit.create(AuthApiService::class.java)

    @Provides
    fun providesHomeService(retrofit: Retrofit): HomeApiService = retrofit.create(HomeApiService::class.java)


}
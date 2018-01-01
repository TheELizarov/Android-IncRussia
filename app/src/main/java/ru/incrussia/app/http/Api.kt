package ru.incrussia.app.http

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.incrussia.app.BuildConfig

/**
 * Created by Sergey Elizarov elizarov1988@gmail.com
 *    on 02.01.2018 0:24
 *
 */
object Api {
    /**
     * Base URL, example https://incrussia.ru/journal/?paged=2&posts_per_page=20&category=2
     */
    val URL = "https://incrussia.ru/journal/";

    class Builder {
        internal fun build(): Api {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE


            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logInterceptor)
                    .build()

            val gson = GsonBuilder().setPrettyPrinting().create()
            val gsonConverterFactory = GsonConverterFactory.create(gson)

            val retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(gsonConverterFactory)
                    .build()

            return retrofit.create(Api.javaClass)
        }

    }
}
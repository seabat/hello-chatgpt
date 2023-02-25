package dev.seabat.android.hellochatgpt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.seabat.android.hellochatgpt.model.net.API_KEY
import dev.seabat.android.hellochatgpt.model.net.BASE_URL
import dev.seabat.android.hellochatgpt.data.source.openai.OpenAiService
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OpenAiServiceModule {
    private var client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val newRequest: Request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer $API_KEY")
                .build()
            chain.proceed(newRequest)
        }.build()

    @Provides
    @Singleton
    fun provideOpenAiService(): OpenAiService = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenAiService::class.java)
}
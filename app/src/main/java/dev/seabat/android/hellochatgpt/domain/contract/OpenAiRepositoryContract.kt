package dev.seabat.android.hellochatgpt.domain.contract

import dev.seabat.android.hellochatgpt.data.OpenAiResponse
import okhttp3.RequestBody

interface OpenAiRepositoryContract {
    suspend fun getPrompt(message: RequestBody): OpenAiResponse
}
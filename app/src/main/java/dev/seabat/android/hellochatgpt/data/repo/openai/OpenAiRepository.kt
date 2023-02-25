package dev.seabat.android.hellochatgpt.data.repo.openai

import dev.seabat.android.hellochatgpt.data.source.openai.OpenAiResponse
import dev.seabat.android.hellochatgpt.data.source.openai.OpenAiService
import okhttp3.RequestBody
import javax.inject.Inject

class OpenAiRepository @Inject constructor(private val apiService: OpenAiService) {
    suspend fun getPrompt(message: RequestBody): OpenAiResponse {
        return apiService.getPrompt(message)
    }
}
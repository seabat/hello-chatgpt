package dev.seabat.android.hellochatgpt.data.repo.openai

import dev.seabat.android.hellochatgpt.data.source.openai.OpenAiResponse
import dev.seabat.android.hellochatgpt.data.source.openai.OpenAiService
import dev.seabat.android.hellochatgpt.domain.contract.OpenAiRepositoryContract
import okhttp3.RequestBody
import javax.inject.Inject

class OpenAiRepository @Inject constructor(private val apiService: OpenAiService):
    OpenAiRepositoryContract {
    override suspend fun getPrompt(message: RequestBody): OpenAiResponse {
        return apiService.getPrompt(message)
    }
}
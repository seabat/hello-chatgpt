package dev.seabat.android.hellochatgpt.domain.contract

import dev.seabat.android.hellochatgpt.domain.entities.ChatGptData
import okhttp3.RequestBody

interface OpenAiRepositoryContract {
    suspend fun getPrompt(query: String): ChatGptData
}
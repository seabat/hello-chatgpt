package dev.seabat.android.hellochatgpt.domain.usecase

import dev.seabat.android.hellochatgpt.domain.contract.OpenAiRepositoryContract
import dev.seabat.android.hellochatgpt.domain.entities.ChatGptData
import javax.inject.Inject

class ChatGptUseCase @Inject constructor(private val repository: OpenAiRepositoryContract) {
    suspend fun sendMessage(query: String): ChatGptData {
        return repository.getPrompt(query)
    }
}
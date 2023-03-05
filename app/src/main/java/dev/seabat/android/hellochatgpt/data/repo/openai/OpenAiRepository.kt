package dev.seabat.android.hellochatgpt.data.repo.openai

import dev.seabat.android.hellochatgpt.data.source.openai.OpenAiRequest
import dev.seabat.android.hellochatgpt.data.source.openai.OpenAiService
import dev.seabat.android.hellochatgpt.data.source.openai.createOpenAiRequestJson
import dev.seabat.android.hellochatgpt.domain.contract.OpenAiRepositoryContract
import dev.seabat.android.hellochatgpt.domain.entities.ChatGptData
import dev.seabat.android.hellochatgpt.model.net.MEDIA_TYPE_JSON
import dev.seabat.android.hellochatgpt.model.net.TEXT_DAVINCI_003
import okhttp3.RequestBody
import javax.inject.Inject

class OpenAiRepository @Inject constructor(private val apiService: OpenAiService):
    OpenAiRepositoryContract {
    override suspend fun getPrompt(query: String): ChatGptData {
        val requestBody = RequestBody.create(
            MEDIA_TYPE_JSON,
            createOpenAiRequestJson(
                OpenAiRequest(
                    TEXT_DAVINCI_003,
                    query,
                    100,
                    0f,
//                    1f,
//                    1,
//                    false,
//                    null,
//                    "\n"
                )
            )
        )
        val response = apiService.getPrompt(requestBody)
        return ChatGptData(query, response.choices[0].text)
    }
}
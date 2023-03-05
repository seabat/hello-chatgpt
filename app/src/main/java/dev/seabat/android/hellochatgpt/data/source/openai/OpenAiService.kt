package dev.seabat.android.hellochatgpt.data.source.openai

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/*
see. https://platform.openai.com/docs/api-reference/making-requests
 ```
 curl https://api.openai.com/v1/completions \
   -H "Content-Type: application/json" \
   -H "Authorization: Bearer YOUR_API_KEY" \
   -d '{"model": "text-davinci-003", "prompt": "Say this is a test", "temperature": 0, "max_tokens": 7}'
  ```
  response
  {
    "id": "cmpl-GERzeJQ4lvqPk8SkZu4XMIuR",
    "object": "text_completion",
    "created": 1586839808,
    "model": "text-davinci:003",
    "choices": [
        {
            "text": "\n\nThis is indeed a test",
            "index": 0,
            "logprobs": null,
            "finish_reason": "length"
        }
    ],
    "usage": {
        "prompt_tokens": 5,
        "completion_tokens": 7,
        "total_tokens": 12
    }
  }
 */
interface OpenAiService {
    @POST("completions")
    suspend fun getPrompt(@Body body: RequestBody): OpenAiResponse
}
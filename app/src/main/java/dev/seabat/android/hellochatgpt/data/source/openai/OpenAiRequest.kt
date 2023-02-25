package dev.seabat.android.hellochatgpt.data.source.openai

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/*
{
  "model": "text-davinci-003",
  "prompt": "Say this is a test",
  "max_tokens": 7,
  "temperature": 0,
  "top_p": 1,
  "n": 1,
  "stream": false,
  "logprobs": null,
  "stop": "\n"
}
 */

data class OpenAiRequest(
    @SerializedName("model")
    val model: String,

    @SerializedName("prompt")
    val prompt: String,

    @SerializedName("max_tokens")
    val maxTokens: Int,

    @SerializedName("temperature")
    val temperature: Float,

//    @SerializedName("top_p")
//    val top_p: Float,
//
//    @SerializedName("n")
//    val n: Int,
//
//    @SerializedName("stream")
//    val stream: Boolean,
//
//    @SerializedName("logprobs")
//    val logprobs: Any?,
//
//    @SerializedName("stop")
//    val stop: String?
)

fun createOpenAiRequestJson(jsonData: OpenAiRequest): String {
    return Gson().toJson(jsonData)
}
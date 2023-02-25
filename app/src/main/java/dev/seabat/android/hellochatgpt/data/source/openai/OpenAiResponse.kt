package dev.seabat.android.hellochatgpt.data.source.openai

import com.google.gson.annotations.SerializedName

/*
{
  "id": "cmpl-uqkvlQyYK7bGYrRHQ0eXlWi7",
  "object": "text_completion",
  "created": 1589478378,
  "model": "text-davinci-003",
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

data class OpenAiResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("object")
    val `object`: String,

    @SerializedName("created")
    val created: Int,

    @SerializedName("choices")
    val choices: List<Choice>,

    @SerializedName("model")
    val model: String,

    @SerializedName("usage")
    val usage: Usage
)
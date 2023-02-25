package dev.seabat.android.hellochatgpt.data.source.openai

import com.google.gson.annotations.SerializedName

data class Choice(
    @SerializedName("text")
    val text: String,

    @SerializedName("index")
    val index: Int,

    @SerializedName("logprobs")
    val logprobs: Any?,

    @SerializedName("finish_reason")
    val finish_reason: String
)
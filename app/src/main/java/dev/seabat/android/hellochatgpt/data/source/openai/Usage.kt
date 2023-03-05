package dev.seabat.android.hellochatgpt.data.source.openai

import com.google.gson.annotations.SerializedName

data class Usage(
    @SerializedName("prompt_tokens")
    val prompt_tokens: Int,

    @SerializedName("completion_tokens")
    val completion_tokens: Int,

    @SerializedName("total_tokens")
    val total_tokens: Int
)
package dev.seabat.android.hellochatgpt.model.net

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull

val MEDIA_TYPE_JSON: MediaType? = "application/json; charset=UTF-8".toMediaTypeOrNull()
val TEXT_DAVINCI_003 = "text-davinci-003"
val API_KEY = ""
val BASE_URL = "https://api.openai.com/v1/"

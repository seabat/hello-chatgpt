package dev.seabat.android.hellochatgpt.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatGptData(val question: String, val answer: String): Parcelable
package dev.seabat.android.hellochatgpt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.seabat.android.hellochatgpt.data.source.openai.OpenAiRequest
import dev.seabat.android.hellochatgpt.data.source.openai.createOpenAiRequestJson
import dev.seabat.android.hellochatgpt.model.net.MEDIA_TYPE_JSON
import dev.seabat.android.hellochatgpt.model.net.TEXT_DAVINCI_003
import dev.seabat.android.hellochatgpt.data.repo.openai.OpenAiRepository
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: OpenAiRepository
) : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    fun sendMessage(query: String) {
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
        viewModelScope.launch {
            val response = repository.getPrompt(requestBody)
            _response.value = response.choices[0].text

        }
    }

}
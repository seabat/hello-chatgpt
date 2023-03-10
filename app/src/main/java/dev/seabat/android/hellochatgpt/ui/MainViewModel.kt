package dev.seabat.android.hellochatgpt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.seabat.android.hellochatgpt.domain.entities.ChatGptData
import dev.seabat.android.hellochatgpt.domain.usecase.ChatGptUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val chatGpt: ChatGptUseCase
) : ViewModel() {

    private val _chatGptData = MutableLiveData<ChatGptData>()
    val chatGptData: LiveData<ChatGptData>
        get() = _chatGptData

    fun sendMessage(query: String) {
        viewModelScope.launch {
            _chatGptData.value = chatGpt.sendMessage(query)
        }
    }

}
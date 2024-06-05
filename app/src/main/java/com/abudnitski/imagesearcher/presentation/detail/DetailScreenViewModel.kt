package com.abudnitski.imagesearcher.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abudnitski.imagesearcher.data.PhotoRepository
import com.abudnitski.imagesearcher.ui.PHOTO_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val repo: PhotoRepository,
    private val saveState: SavedStateHandle,
    private val convertorHelper: ConvertorHelper
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailScreenUiState())
    val uiState: StateFlow<DetailScreenUiState> = _uiState

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val photoId = saveState.get<String>(PHOTO_ID)
                val data = photoId?.let { repo.findPhoto(it) }
                data?.let {
                    _uiState.value =
                        _uiState.value.copy(
                            likes = convertorHelper.convert(data.likes),
                            views = convertorHelper.convert(data.views),
                            user = data.user,
                            id = data.id.toString(),
                            comments = convertorHelper.convert(data.comments),
                            download = convertorHelper.convert(data.downloads),
                            photoUrl = data.largeImageURL,
                            tags = convertorHelper.convert(data.tags)
                        )
                }
            } catch (e: Exception) {
                //TODO dodaj flage do uistate i ja tu ustaw zeby pokazac jakis error w UI
            }
        }
    }
}
package com.abudnitski.imagesearcher.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abudnitski.imagesearcher.data.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repo: PhotoRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainScreenUiState(query = INITIAL_QUERY))
    val uiState: StateFlow<MainScreenUiState> = _uiState

    init {
        load(_uiState.value.query)
    }

    private fun load(searchText: String) {
        _uiState.value = _uiState.value.copy(isDataLoading = true, query = searchText)
        viewModelScope.launch(Dispatchers.IO) {//main
            try {
                val data = repo.getAllPhotos(searchText)
                _uiState.value =
                    _uiState.value.copy(photos = data, isDataLoading = false, isDataError = data.isEmpty())
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(isDataLoading = false, isDataError = true)
                }
            }
        }
    }

    fun onSearchClicked(searchText: String) {
        if (_uiState.value.query != searchText) {
            load(searchText)
        }
    }

    fun onPreviewItemClicked(id: Int) {
        _uiState.value = _uiState.value.copy(showPreviewDialog = true, selectedId = id)
    }

    fun onPreviewDialogDismissed() {
        _uiState.value = _uiState.value.copy(showPreviewDialog = false)
    }

    fun onTryAgainClicked() {
        load(_uiState.value.query)
    }

}

const val INITIAL_QUERY = "fruits"

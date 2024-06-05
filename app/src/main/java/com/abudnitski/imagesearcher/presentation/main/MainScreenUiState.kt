package com.abudnitski.imagesearcher.presentation.main

import com.abudnitski.imagesearcher.domain.Photo

data class MainScreenUiState(
    val photos: List<Photo> = emptyList(),
    val selectedId: Int = 0,
    val isDataError: Boolean = false,
    val tryAgainButton: () -> Unit = {},
    val isDataLoading: Boolean = false,
    val showPreviewDialog: Boolean = false,
    val query : String = "",
)
package com.abudnitski.imagesearcher.ui.mainScreen

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.abudnitski.imagesearcher.R
import com.abudnitski.imagesearcher.presentation.main.MainScreenViewModel
import com.abudnitski.imagesearcher.ui.common.AlertDialogComponent
import com.abudnitski.imagesearcher.ui.common.LoadingIndicator

@Composable
fun MainScreen(onGoToDetail: (Int) -> Unit) {
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val mainScreenUiState = viewModel.uiState.collectAsState().value

    Column {
        TopAppSearchBar(query = mainScreenUiState.query, onSearchClick = { viewModel.onSearchClicked(it) })
        if (mainScreenUiState.isDataLoading) {
            LoadingIndicator()
        } else {
            PreviewGrid(mainScreenUiState = mainScreenUiState, onItemClick = { viewModel.onPreviewItemClicked(it) })
        }
    }

    if (mainScreenUiState.isDataError) {
        val activity = (LocalContext.current as? Activity)
        AlertDialogComponent(
            dialogTitle = stringResource(R.string.dialog_error_title),
            dialogText = stringResource(R.string.dialog_error_message),
            confirmButtonText = stringResource(R.string.dialog_generic_try_reconnecting),
            dismissButtonText = stringResource(R.string.dialog_generic_exit),
            onConfirmation = { viewModel.onTryAgainClicked() },
            onDismissRequest = { /*do nothing*/ },
            onDismissButton = { activity?.finish() })
    }


    if (mainScreenUiState.showPreviewDialog) {
        AlertDialogComponent(
            dialogTitle = stringResource(R.string.dialog_preview_title),
            dialogText = stringResource(R.string.dialog_preview_message),
            confirmButtonText = stringResource(R.string.dialog_generic_yes),
            dismissButtonText = stringResource(R.string.dialog_generic_not_yet),
            onConfirmation = {
                onGoToDetail(mainScreenUiState.selectedId)
                viewModel.onPreviewDialogDismissed()
            },
            onDismissButton = { viewModel.onPreviewDialogDismissed() },
            onDismissRequest = { viewModel.onPreviewDialogDismissed() }
        )
    }
}

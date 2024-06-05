package com.abudnitski.imagesearcher.ui.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun AlertDialogComponent(
    dialogTitle: String,
    dialogText: String,
    confirmButtonText: String,
    dismissButtonText: String = "",
    onDismissRequest: () -> Unit,
    onDismissButton: () -> Unit,
    onConfirmation: () -> Unit

) {
    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(text = confirmButtonText)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissButton()
                }
            ) {
                Text(text = dismissButtonText)
            }
        }
    )
}

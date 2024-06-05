package com.abudnitski.imagesearcher.ui.detailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abudnitski.imagesearcher.R
import com.abudnitski.imagesearcher.presentation.detail.DetailScreenUiState

@Composable
fun Metadata(detailScreenUiState: DetailScreenUiState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row {
                Text(
                    text = stringResource(R.string.detail_metadata_author, detailScreenUiState.user),
                    fontFamily = FontFamily.Serif
                )
            }
            Row {
                Text(text = detailScreenUiState.tags, fontFamily = FontFamily.SansSerif, fontSize = 12.sp)
            }
        }
    }
}

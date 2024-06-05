package com.abudnitski.imagesearcher.ui.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.abudnitski.imagesearcher.presentation.detail.DetailScreenUiState
import com.abudnitski.imagesearcher.ui.common.shimmerBrush

@Composable
fun LargePhoto(uiState: DetailScreenUiState) {
    val showShimmer = remember { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp, end = 8.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box {
            AsyncImage(
                model = uiState.photoUrl,
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .heightIn(min = 200.dp)
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = showShimmer.value)),
                onSuccess = { showShimmer.value = false }
            )
        }
    }
}



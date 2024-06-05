package com.abudnitski.imagesearcher.ui.detailScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abudnitski.imagesearcher.R
import com.abudnitski.imagesearcher.presentation.detail.DetailScreenUiState
import com.abudnitski.imagesearcher.presentation.detail.DetailScreenViewModel

@Composable
fun DetailScreen(onBackClick: () -> Unit) {
    val viewmodel = hiltViewModel<DetailScreenViewModel>()
    val detailScreenUiState = viewmodel.uiState.collectAsState().value
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            OutlinedButton(
                onClick = { onBackClick() },
                border = BorderStroke(0.dp, Color.Transparent),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(R.string.generic_back_accessibility),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Text(text = "") // for transparent icon background
            }
            Spacer(modifier = Modifier.weight(4f))
        }

        Box(modifier = Modifier.fillMaxSize()) {
            ElevatedCard(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                LargePhoto(detailScreenUiState)
                Metadata(detailScreenUiState)
                PhotoStats(detailScreenUiState)
            }
        }
    }
}


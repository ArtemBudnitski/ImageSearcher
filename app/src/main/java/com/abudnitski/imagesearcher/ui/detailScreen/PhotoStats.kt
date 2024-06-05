package com.abudnitski.imagesearcher.ui.detailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.abudnitski.imagesearcher.R
import com.abudnitski.imagesearcher.presentation.detail.DetailScreenUiState

@Composable
fun PhotoStats(detailScreenUiState: DetailScreenUiState) {
    Row(modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 8.dp, top = 8.dp)) {
        Row(
            modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_eye),
                contentDescription = stringResource(R.string.photo_stats_views_accessibility),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp)
            )
            Text(text = detailScreenUiState.views)
        }
        Row(
            modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = stringResource(R.string.photo_stats_likes_accessibility),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp)
            )
            Text(text = detailScreenUiState.likes)
        }
        Row(
            modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_comment),
                contentDescription = stringResource(R.string.photo_stats_comments_accessibility),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp)
            )
            Text(text = detailScreenUiState.comments)

        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_download),
                contentDescription = stringResource(R.string.photo_stats_downloads_accessibility),
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp)
            )
            Text(text = detailScreenUiState.download)
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PhotoStatsPreview(
    @PreviewParameter(PhotoStatsParameterProvider::class) detailScreenUiState: DetailScreenUiState
) {
    MaterialTheme {
        PhotoStats(detailScreenUiState)
    }
}

class PhotoStatsParameterProvider : PreviewParameterProvider<DetailScreenUiState> {
    override val values: Sequence<DetailScreenUiState> = sequenceOf(

        DetailScreenUiState(likes = "1000", views = "2000", comments = "3000", download = "4000")
    )

}

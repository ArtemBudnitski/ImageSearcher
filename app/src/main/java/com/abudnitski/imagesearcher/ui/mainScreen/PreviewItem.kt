package com.abudnitski.imagesearcher.ui.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.abudnitski.imagesearcher.domain.Photo
import com.abudnitski.imagesearcher.ui.common.shimmerBrush

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewItem(photo: Photo, onItemClick: () -> Unit) {
    val showShimmer = remember { mutableStateOf(true) }
    Card(modifier = Modifier, shape = RoundedCornerShape(15.dp), onClick = { onItemClick() }) {
        Column(modifier = Modifier.fillMaxSize()) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp), shape = RoundedCornerShape(15.dp)
            ) {
                AsyncImage(
                    model = photo.webformatURL,
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .heightIn(min = (photo.previewHeight).dp)
                        .background(shimmerBrush(targetValue = 1300f, showShimmer = showShimmer.value)),
                    onSuccess = { showShimmer.value = false }
                )
            }
            Column(modifier = Modifier.padding(start = 12.dp, bottom = 12.dp, top = 4.dp)) {
                Text(
                    text = photo.user,
                    fontSize = 12.sp,
                    modifier = Modifier,
                    fontWeight = FontWeight.Normal,
                )

                Text(
                    text = photo.tags,
                    fontSize = 6.sp,
                    modifier = Modifier,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewItemPreview() {
    MaterialTheme {
        PreviewItem(
            photo = Photo(
                1,
                "tagOne, tagTwo, tagThree",
                "https://cdn.pixabay.com/photo/2018/06/24/23/21/daylily-3495722_150.jpg",
                "https://pixabay.com/get/gae2a05011d86fa9538b531b72cca21e6ac6cd9b7895e608458267912986118e4dfc0a1ab9ffb8ce58834062419a374164dce9e70a12e3a884eb6b07fbe080789_640.jpg",
                1000, 200, 44000, 2000, "Artem", 10000, 10)
        ) {}
    }
}
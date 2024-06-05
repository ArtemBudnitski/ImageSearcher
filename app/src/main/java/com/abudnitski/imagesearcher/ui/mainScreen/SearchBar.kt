package com.abudnitski.imagesearcher.ui.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abudnitski.imagesearcher.R

@Composable
fun TopAppSearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onSearchClick: (String) -> Unit,
) {
    var searchText by remember { mutableStateOf(query) }
    Row(
        modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = modifier.weight(0.1f))
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text(text = stringResource(R.string.search_hint), fontWeight = FontWeight.Normal) },
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 4.dp),
            shape = MaterialTheme.shapes.medium,
            singleLine = true,
            colors = TextFieldDefaults.colors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = { onSearchClick(searchText) }
            )

        )
        IconButton(onClick = { onSearchClick(searchText) }, Modifier.weight(0.3f)) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = stringResource(R.string.search_icon_accessibility),
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewTopAppSearchBar(){
    MaterialTheme{
        TopAppSearchBar(Modifier, " ") {  }
    }
}

package com.oscar.retocsti.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun ListScreen() {
    val viewModel = hiltViewModel<ListViewModel>()

    val users = viewModel.users.collectAsState().value

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = users, itemContent = { model ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        modifier = Modifier.width(92.dp).height(92.dp),
                        model = model.avatar,
                        contentDescription = "Avatar",
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(16.dp).align(CenterVertically),
                    ) {
                        Text(text = "${model.firstName} ${model.lastName}")
                        Text(text = model.email)
                    }
                }
                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    thickness = 1.dp,
                    color = Color.LightGray,
                )
            })
        }
    }
}

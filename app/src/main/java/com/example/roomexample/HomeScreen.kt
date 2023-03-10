package com.example.roomexample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = { viewModel.getWords() }
        ) {
            Text(text = "Listele")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = { viewModel.addBook(Words(3, "sadd", "sdsddd")) }
        ) {
            Text(text = "Ekle")
        }
        Spacer(modifier = Modifier.height(50.dp))

        LazyColumn(content = {
            items(viewModel.words) {
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        it.englishWords?.let { it1 -> Text(text = it1) }
                        it.turkishWords?.let { it1 -> Text(text = it1) }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        })
    }


}
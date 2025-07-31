package ru.resodostudio.flick.feature.people

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import ru.resodostudio.flick.core.designsystem.component.FlickAsyncImage
import ru.resodostudio.flick.core.model.data.Person

@Composable
internal fun PeopleRoute(
    onPersonClick: (Int) -> Unit,
    viewModel: PeopleViewModel = hiltViewModel(),
) {
    val peopleState = viewModel.peopleState.collectAsLazyPagingItems()
    PeopleScreen(
        peopleState = peopleState,
        onPersonClick = onPersonClick,
    )
}

@Composable
internal fun PeopleScreen(
    peopleState: LazyPagingItems<Person>,
    onPersonClick: (Int) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(300.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        people(
            peopleState = peopleState,
            onPersonClick = onPersonClick,
        )
    }
}

private fun LazyGridScope.people(
    peopleState: LazyPagingItems<Person>,
    onPersonClick: (Int) -> Unit,
) {
    items(
        count = peopleState.itemCount,
        key = peopleState.itemKey { it.id },
        contentType = peopleState.itemContentType { "People" },
    ) { index ->
        peopleState[index]?.let { person ->
            ListItem(
                headlineContent = { Text(text = person.originalName) },
                supportingContent = { Text(text = person.name) },
                leadingContent = {
                    Box {
                        FlickAsyncImage(
                            url = "",
                            contentDescription = "Person image",
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .size(56.dp),
                            contentScale = ContentScale.Crop,
                        )
                    }
                },
                modifier = Modifier.clickable { onPersonClick(person.id) },
            )
        }
    }
}
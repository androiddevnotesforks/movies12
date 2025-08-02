package ru.resodostudio.flick.feature.people

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
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
    val isRefreshing = peopleState.loadState.refresh is LoadState.Loading
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = { peopleState.refresh() },
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            people(
                peopleState = peopleState,
                onPersonClick = onPersonClick,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
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
            PersonCard(
                person = person,
                onPersonClick = onPersonClick,
                modifier = Modifier.animateItem(),
            )
        }
    }
    if (peopleState.loadState.append is LoadState.Loading) {
        item(
            span = { GridItemSpan(maxLineSpan) },
            contentType = { "Loading" },
        ) {
            ContainedLoadingIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .animateItem(),
            )
        }
    }
}


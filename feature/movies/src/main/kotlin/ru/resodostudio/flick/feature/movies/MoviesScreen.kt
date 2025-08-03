package ru.resodostudio.flick.feature.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import ru.resodostudio.flick.core.model.data.Movie

@Composable
internal fun MoviesRoute(
    viewModel: MoviesViewModel = hiltViewModel(),
    onMovieClick: (Int) -> Unit,
) {
    val moviesState = viewModel.moviesState.collectAsLazyPagingItems()
    MoviesScreen(
        moviesState = moviesState,
        onMovieClick = onMovieClick,
    )
}

@Composable
private fun MoviesScreen(
    moviesState: LazyPagingItems<Movie>,
    onMovieClick: (Int) -> Unit,
) {
    val isRefreshing = moviesState.loadState.refresh is LoadState.Loading
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = { moviesState.refresh() },
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(160.dp),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            movies(
                moviesState = moviesState,
                onMovieClick = onMovieClick,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
private fun LazyStaggeredGridScope.movies(
    moviesState: LazyPagingItems<Movie>,
    onMovieClick: (Int) -> Unit,
) {
    items(
        count = moviesState.itemCount,
        key = moviesState.itemKey { it.id },
        contentType = moviesState.itemContentType { "Movies" },
    ) { index ->
        moviesState[index]?.let { movie ->
            MovieCard(
                movie = movie,
                onMovieClick = onMovieClick,
                modifier = Modifier.animateItem(),
            )
        }
    }
    if (moviesState.loadState.append is LoadState.Loading) {
        item(
            span = StaggeredGridItemSpan.FullLine,
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
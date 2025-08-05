package ru.resodostudio.flick.feature.tvshows

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
import ru.resodostudio.flick.core.model.TvShow

@Composable
internal fun TvShowsRoute(
    viewModel: TvShowsViewModel = hiltViewModel(),
    onTvShowClick: (Int) -> Unit,
) {
    val tvShowsState = viewModel.tvShowsState.collectAsLazyPagingItems()
    TvShowsScreen(
        tvShowsState = tvShowsState,
        onTvShowClick = onTvShowClick,
    )
}

@Composable
private fun TvShowsScreen(
    tvShowsState: LazyPagingItems<TvShow>,
    onTvShowClick: (Int) -> Unit,
) {
    val isRefreshing = tvShowsState.loadState.refresh is LoadState.Loading
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = { tvShowsState.refresh() },
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(160.dp),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            tvShows(
                tvShowsState = tvShowsState,
                onTvShowClick = onTvShowClick,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
private fun LazyStaggeredGridScope.tvShows(
    tvShowsState: LazyPagingItems<TvShow>,
    onTvShowClick: (Int) -> Unit,
) {
    items(
        count = tvShowsState.itemCount,
        key = tvShowsState.itemKey { it.id },
        contentType = tvShowsState.itemContentType { "TvShows" },
    ) { index ->
        tvShowsState[index]?.let { tvShow ->
            TvShowCard(
                tvShow = tvShow,
                onTvShowClick = onTvShowClick,
                modifier = Modifier.animateItem(),
            )
        }
    }
    if (tvShowsState.loadState.append is LoadState.Loading) {
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
package ru.resodostudio.flick.core.network.resource

import io.ktor.resources.Resource

@Resource("movie")
internal class MovieResource() {

    @Resource("popular")
    internal class Popular(
        val parent: MovieResource = MovieResource(),
        val page: Int = 1,
    )
}
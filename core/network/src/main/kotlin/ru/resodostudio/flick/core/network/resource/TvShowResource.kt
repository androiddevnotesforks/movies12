package ru.resodostudio.flick.core.network.resource

import io.ktor.resources.Resource

@Resource("tv")
internal class TvShowResource() {

    @Resource("popular")
    internal class Popular(
        val parent: TvShowResource = TvShowResource(),
        val page: Int = 1,
    )
}
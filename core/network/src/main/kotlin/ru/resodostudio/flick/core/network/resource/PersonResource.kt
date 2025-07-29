package ru.resodostudio.flick.core.network.resource

import io.ktor.resources.Resource

@Resource("person")
internal class PersonResource() {

    @Resource("popular")
    internal class Popular(val parent: PersonResource = PersonResource())
}
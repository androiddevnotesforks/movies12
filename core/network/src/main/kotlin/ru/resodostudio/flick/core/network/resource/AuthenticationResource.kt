package ru.resodostudio.flick.core.network.resource

import io.ktor.resources.Resource

@Resource("authentication")
internal class AuthenticationResource {

    @Resource("token/new")
    internal class NewToken(
        val parent: AuthenticationResource = AuthenticationResource(),
    )
}
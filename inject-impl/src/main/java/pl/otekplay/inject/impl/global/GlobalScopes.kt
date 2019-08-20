package pl.otekplay.inject.impl.global

import pl.otekplay.inject.impl.scope.ScopeHolderImpl
import pl.otekplay.inject.impl.scope.SingleRepositoryScope

fun pl.otekplay.inject.api.global.GlobalScope.installDefault() {
    val single = SingleRepositoryScope()
    val holder = ScopeHolderImpl(single)
    setup(holder)
}
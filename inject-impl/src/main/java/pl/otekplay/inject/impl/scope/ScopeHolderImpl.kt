package pl.otekplay.inject.impl.scope

import pl.otekplay.inject.api.scope.Scope
import pl.otekplay.inject.api.scope.ScopeHolder

class ScopeHolderImpl(override val root: Scope) : ScopeHolder
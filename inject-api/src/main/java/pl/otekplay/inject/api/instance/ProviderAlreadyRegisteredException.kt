package pl.otekplay.inject.api.instance

import kotlin.reflect.KClass

class ProviderAlreadyRegisteredException(
        kClass: KClass<*>
) : ProviderException("Provider for class ${kClass.qualifiedName ?: kClass.java.name} is already registered.")
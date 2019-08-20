package pl.otekplay.inject.api.instance

import java.lang.RuntimeException
import kotlin.reflect.KClass

class ProviderNotFoundException(
        kClass: KClass<*>
) : ProviderException("Provider for class ${kClass.qualifiedName ?: kClass.java.name} has been not found.")
package pl.otekplay.inject.api.scope

import pl.otekplay.inject.api.instance.ProviderAlreadyRegisteredException
import java.lang.IllegalArgumentException
import java.nio.file.ProviderNotFoundException
import kotlin.reflect.KClass

interface Scope {
    @Throws(
            IllegalArgumentException::class,
            ProviderNotFoundException::class
    )
    fun <T : Any> getInstanceByClazz(kClass: KClass<T>): T
    @Throws(
            IllegalArgumentException::class,
            ProviderNotFoundException::class
    )
    fun <T : Any> getLazyInstanceByClazz(kClass: KClass<T>): Lazy<T>

    @Throws(ProviderAlreadyRegisteredException::class)
    fun <T : Any> registerFactory(inter: KClass<T>, factoryClazz:KClass<out T>)

    @Throws(ProviderAlreadyRegisteredException::class)
    fun <T : Any> registerSingleton(inter: KClass<T>, singleton: T)

    @Throws(ProviderAlreadyRegisteredException::class)
    fun <T : Any> registerSingleton(inter: KClass<T>, clazz:KClass<out T>)

    fun isRegistered(inter:KClass<*>):Boolean
}
package pl.otekplay.inject.api.instance

import kotlin.reflect.KClass

interface InstanceProviderRepository {

    @Throws(ProviderNotFoundException::class)
    operator fun <T : Any> get(clazz: KClass<T>): InstanceProvider<T>

    @Throws(ProviderAlreadyRegisteredException::class)
    operator fun <T : Any> set(inter: KClass<T>, provider: InstanceProvider<T>)

    fun has(inter:KClass<*>):Boolean



}



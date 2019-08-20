package pl.otekplay.inject.impl.instance

import pl.otekplay.inject.api.instance.InstanceProvider
import pl.otekplay.inject.api.instance.InstanceProviderRepository
import pl.otekplay.inject.api.instance.ProviderAlreadyRegisteredException
import pl.otekplay.inject.api.instance.ProviderNotFoundException
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

class InstanceProviderRepositoryImpl : InstanceProviderRepository {
    private val map = ConcurrentHashMap<KClass<*>, InstanceProvider<*>>()
    override fun <T : Any> get(clazz: KClass<T>): InstanceProvider<T> {
        val provider = map[clazz] ?: throw ProviderNotFoundException(clazz)
        return provider as InstanceProvider<T>
    }

    override fun <T : Any> set(inter: KClass<T>, provider: InstanceProvider<T>) = if (!has(inter)) map[inter] = provider else throw ProviderAlreadyRegisteredException(inter)


    override fun has(inter: KClass<*>) = map.containsKey(inter)
}
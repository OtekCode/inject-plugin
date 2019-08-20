package pl.otekplay.inject.impl.scope

import pl.otekplay.inject.api.instance.InstanceProvider
import pl.otekplay.inject.api.instance.InstanceProviderRepository
import pl.otekplay.inject.api.scope.Scope
import pl.otekplay.inject.impl.instance.FactoryInstanceProvider
import pl.otekplay.inject.impl.instance.InstanceProviderRepositoryImpl
import pl.otekplay.inject.impl.instance.LazySingletonInstanceProvider
import pl.otekplay.inject.impl.instance.SingletonInstanceProvider
import kotlin.reflect.KClass

class SingleRepositoryScope : Scope {
    private val repository = InstanceProviderRepositoryImpl()

    init {
        registerSingleton(InstanceProviderRepository::class, repository)
        registerSingleton(Scope::class, this)
    }

    private fun <T : Any> registerProvider(inter: KClass<T>, provider: InstanceProvider<T>) {
        repository[inter] = provider
    }

    override fun <T : Any> getInstanceByClazz(kClass: KClass<T>) = repository[kClass].instance

    override fun <T : Any> getLazyInstanceByClazz(kClass: KClass<T>) = lazy { getInstanceByClazz(kClass) }

    override fun <T : Any> registerFactory(inter: KClass<T>, factoryClazz: KClass<out T>) = registerProvider(inter, FactoryInstanceProvider(factoryClazz))

    override fun <T : Any> registerSingleton(inter: KClass<T>, singleton: T) = registerProvider(inter, SingletonInstanceProvider(singleton))

    override fun <T : Any> registerSingleton(inter: KClass<T>, clazz: KClass<out T>)= registerProvider(inter,LazySingletonInstanceProvider(clazz))

    override fun isRegistered(inter: KClass<*>) = repository.has(inter)
}
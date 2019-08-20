package pl.otekplay.inject.impl.instance

import pl.otekplay.inject.api.instance.InstanceProvider
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class LazySingletonInstanceProvider<T : Any>(private val clazz: KClass<out T>) : InstanceProvider<T> {
    private val lazy = lazy { clazz.createInstance() }
    override val instance: T get() = lazy.value
}
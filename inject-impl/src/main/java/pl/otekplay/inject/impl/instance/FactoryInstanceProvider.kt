package pl.otekplay.inject.impl.instance

import pl.otekplay.inject.api.instance.InstanceProvider
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class FactoryInstanceProvider<T : Any>(clazz: KClass<out T>) : InstanceProvider<T> {
    override val instance = clazz.createInstance()
}
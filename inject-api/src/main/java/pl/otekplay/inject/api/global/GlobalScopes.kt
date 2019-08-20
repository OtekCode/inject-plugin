package pl.otekplay.inject.api.global

import pl.otekplay.inject.api.ktype.convertedKotlinClass
import kotlin.reflect.KClass
import kotlin.reflect.typeOf


@Throws(pl.otekplay.inject.api.global.GlobalScopeException::class)
inline fun <reified T : Any> get() = GlobalScope.getInstanceByClazz(typeOf<T>().convertedKotlinClass<T>())

inline fun <reified T : Any> inject() = GlobalScope.getLazyInstanceByClazz(typeOf<T>().convertedKotlinClass<T>())

@Throws(pl.otekplay.inject.api.global.GlobalScopeException::class)
inline fun <reified T : Any> bind(bind: T) = GlobalScope.registerSingleton(typeOf<T>().convertedKotlinClass(), bind)

@Throws(pl.otekplay.inject.api.global.GlobalScopeException::class)
inline fun <reified T : Any> bind(clazz: KClass<out T>) = GlobalScope.registerSingleton(typeOf<T>().convertedKotlinClass<T>(), clazz)

@Throws(pl.otekplay.inject.api.global.GlobalScopeException::class)
inline fun <reified T : Any> factory(factoryClazz: KClass<T>) = GlobalScope.registerSingleton(typeOf<T>().convertedKotlinClass<T>(), factoryClazz)

package pl.otekplay.inject.api.global

import pl.otekplay.inject.api.scope.Scope
import pl.otekplay.inject.api.scope.ScopeHolder
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

object GlobalScope : Scope {
    private lateinit var holder: ScopeHolder
    private val initialized get() = GlobalScope::holder.isInitialized


    @Throws(GlobalScopeException::class)
    fun setup(sh: ScopeHolder) {
        if (initialized) throw GlobalScopeException("Global holder is already initialized!")
        holder = sh
    }

    @Throws(GlobalScopeException::class)
    private fun check() {
        if (!initialized) throw GlobalScopeException("Global scope is not initialized yet!")
    }

    @Throws(GlobalScopeException::class)
    override fun <T : Any> getInstanceByClazz(kClass: KClass<T>): T {
        check()
        return holder.root.getInstanceByClazz(kClass)
    }

    @Throws(GlobalScopeException::class)
    override fun <T : Any> getLazyInstanceByClazz(kClass: KClass<T>): Lazy<T> {
        check()
        return holder.root.getLazyInstanceByClazz(kClass)
    }

    @Throws(GlobalScopeException::class)
    override fun <T : Any> registerFactory(inter: KClass<T>, factoryClazz: KClass<out T>) {
        check()
        return holder.root.registerFactory(inter, factoryClazz)
    }

    @Throws(GlobalScopeException::class)
    override fun <T : Any> registerSingleton(inter: KClass<T>, singleton: T) {
        check()
        return holder.root.registerSingleton(inter, singleton)
    }

    @Throws(GlobalScopeException::class)
    override fun <T : Any> registerSingleton(inter: KClass<T>, clazz: KClass<out T>) {
        check()
        return holder.root.registerSingleton(inter, clazz)
    }

    @Throws(GlobalScopeException::class)
    override fun isRegistered(inter: KClass<*>): Boolean {
        check()
        return holder.root.isRegistered(inter)
    }

}
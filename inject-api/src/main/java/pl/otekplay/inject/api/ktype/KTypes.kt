package pl.otekplay.inject.api.ktype

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.jvm.jvmErasure

fun <T : Any> KType.convertedKotlinClass() = jvmErasure as KClass<T>
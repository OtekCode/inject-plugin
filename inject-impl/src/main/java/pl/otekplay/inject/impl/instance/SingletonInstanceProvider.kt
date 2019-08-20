package pl.otekplay.inject.impl.instance

import pl.otekplay.inject.api.instance.InstanceProvider

class SingletonInstanceProvider<T:Any>(override val instance: T) : InstanceProvider<T>
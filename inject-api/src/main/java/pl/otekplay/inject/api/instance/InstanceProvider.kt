package pl.otekplay.inject.api.instance

interface InstanceProvider<T:Any> {
    val instance: T
}
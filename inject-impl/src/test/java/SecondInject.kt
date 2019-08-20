import pl.otekplay.inject.api.global.inject

class SecondInject{
    init {

        println("Create second inject")
    }
    val first: FirstInject by inject()
}
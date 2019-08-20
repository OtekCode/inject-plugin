import pl.otekplay.inject.api.global.inject

class FirstInject {
    init {
        println("Create first inject")
    }
    val second: SecondInject by inject()
}
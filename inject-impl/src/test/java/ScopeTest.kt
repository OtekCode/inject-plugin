import org.junit.BeforeClass
import org.junit.Test
import pl.otekplay.inject.api.global.GlobalScope
import pl.otekplay.inject.api.global.bind
import pl.otekplay.inject.api.global.get
import pl.otekplay.inject.api.global.inject
import pl.otekplay.inject.api.instance.ProviderAlreadyRegisteredException
import pl.otekplay.inject.api.instance.ProviderNotFoundException
import pl.otekplay.inject.impl.global.installDefault
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ScopeTest {
    companion object {
        @BeforeClass
        @JvmStatic
        fun setup() {
            GlobalScope.installDefault()
            bind(Double::class)
            bind(Lazy::class)
            bind(Inject::class)
            bind(Get::class)
            bind(Instant())
            bind<Interface>(InterfaceImpl::class)
            bind(FirstInject::class)
            bind(SecondInject::class)
        }
    }

    @Test(expected = ProviderNotFoundException::class)
    fun testMissed() {
        get<Missed>()
    }

    @Test(expected = ProviderAlreadyRegisteredException::class)
    fun testDouble() {
        bind(Double::class)
    }

    @Test
    fun testInject() {
        val test: Inject by inject()
        assertNotNull(test)
    }


    @Test
    fun testGet() {
        assertNotNull(get<Get>())
    }

    @Test
    fun testLazyInject() {
        val lazy = inject<Lazy>()
        assertFalse(lazy.isInitialized())
        assertNotNull(lazy.value)
        assertTrue(lazy.isInitialized())
    }

    @Test
    fun testInstant(){
        assertNotNull(get<Instant>())
    }

    @Test
    fun testInteface(){
        assertNotNull(get<Interface>())
    }
    @Test(expected = ProviderNotFoundException::class)
    fun testIntefaceImpl(){
        assertNotNull(get<InterfaceImpl>())
    }

    @Test
    fun testMultiInjects(){
        val second = get<SecondInject>()
        val first = get<FirstInject>()
        assertEquals(second.first,first)
        assertEquals(first.second,second)
    }
}
package pl.otekplay.inject.plugin

import pl.otekplay.inject.api.global.GlobalScope
import pl.otekplay.inject.api.global.GlobalScopeException
import pl.otekplay.inject.impl.global.installDefault
import java.util.logging.Level
import java.util.logging.Logger

interface DefaultInjectPlugin {


    fun initialize(logger: Logger):Boolean{
        return try {
            GlobalScope.installDefault()
            logger.info("Inject plugin is ready for use!")
            true
        } catch (e: GlobalScopeException) {
            logger.log(Level.SEVERE,"Can't initialize inject plugin error:",e)
            false
        }
    }
}
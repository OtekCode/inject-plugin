package pl.otekplay.inject.bukkit


import org.bukkit.plugin.java.JavaPlugin
import pl.otekplay.inject.plugin.DefaultInjectPlugin

class InjectPlugin: JavaPlugin(), DefaultInjectPlugin {

    override fun onEnable() {
        if(!initialize(logger)){
            logger.info("Disabling inject plugin...")
            server.pluginManager.disablePlugin(this)
        }
    }

}
package pl.otekplay.inject.bungee

import net.md_5.bungee.api.plugin.Plugin
import pl.otekplay.inject.plugin.DefaultInjectPlugin

class InjectPlugin: Plugin(), DefaultInjectPlugin{

    override fun onEnable() {
        initialize(logger)
    }

}
package org.jajader;

import org.bukkit.plugin.java.JavaPlugin;
import org.jajader.Listeners.OreBlockListener;

public final class LuckySurvival extends JavaPlugin {
    public static LuckySurvival INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        getServer().getPluginManager().registerEvents(new OreBlockListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LuckySurvival getInstance() {
        return INSTANCE;
    }
}

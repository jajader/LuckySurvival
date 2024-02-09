package org.jajader;

import org.bukkit.plugin.java.JavaPlugin;
import org.jajader.Listeners.DamageListener;
import org.jajader.Listeners.EntityDropItemListener;
import org.jajader.Listeners.OreBlockListener;
import org.jajader.Listeners.PlayerFirstJoinListener;

public final class LuckySurvival extends JavaPlugin {
    public static LuckySurvival INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        getServer().getPluginManager().registerEvents(new OreBlockListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerFirstJoinListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDropItemListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LuckySurvival getInstance() {
        return INSTANCE;
    }
}

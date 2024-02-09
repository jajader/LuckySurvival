package org.jajader.Listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jajader.LuckySurvival;

public class PlayerFirstJoinListener implements Listener {

    @EventHandler
    public void onPlayerFirstJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPlayedBefore()) return;
        Double a = Math.random();
        if (a < 0.6) {
            Bukkit.getScheduler().runTaskLater(LuckySurvival.getInstance(), () -> {
                e.getPlayer().kick(Component.text("Welcome to LuckySurvival!"));
            }, 1L);
        }
    }
}

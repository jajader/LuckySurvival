package org.jajader.Listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityDropItemListener implements Listener {

    @EventHandler
    public void EntityDead(EntityDeathEvent e) {
        if (e.getEntity() instanceof Player) return;
        e.getDrops().forEach(is -> {
            Double D = Math.random();
            int random = (int) (D*5);
            is.setAmount(is.getAmount()*random);
        });
    }

    @EventHandler
    public void runEvent(PlayerToggleSprintEvent e) {
        float speed = (float) (Math.pow(Math.random(), 3)*1f);
        e.getPlayer().setWalkSpeed(speed);
    }

    @EventHandler
    public void jumpEvent(PlayerJumpEvent e) {
        int level = (int) (Math.pow(Math.random(), 4)*30);
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20, level));
    }

}

package org.jajader.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        double d = Math.random();
        /* 디버그용
        e.getEntity().sendMessage(String.valueOf(e.getDamage()));
        e.getEntity().sendMessage(String.valueOf((e.getDamage()/3) +e.getDamage()*d*3));
         */
        e.setDamage((e.getDamage()/3) +e.getDamage()*d*3);

    }
}

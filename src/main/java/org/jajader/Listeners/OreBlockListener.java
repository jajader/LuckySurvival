package org.jajader.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jajader.LuckySurvival;

import java.util.*;

public class OreBlockListener implements Listener {

    public static HashMap<Material, Double[]> OPtable = new HashMap<>();

    public static List<Block> LuckingBlock = new ArrayList<>();

    public static Material[] oreTable =
            {
                    Material.COAL_ORE, Material.COPPER_ORE, Material.LAPIS_ORE, Material.IRON_ORE, Material.REDSTONE_ORE, Material.DIAMOND_ORE, Material.GOLD_ORE, Material.EMERALD_ORE,
                    Material.DEEPSLATE_COAL_ORE, Material.DEEPSLATE_COPPER_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DEEPSLATE_IRON_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.DEEPSLATE_GOLD_ORE, Material.DEEPSLATE_EMERALD_ORE,
                    Material.NETHER_QUARTZ_ORE, Material.NETHER_GOLD_ORE, Material.NETHERITE_SCRAP
            };

    public static Material[] resultTable =
            {
                    Material.COAL, Material.RAW_COPPER, Material.LAPIS_LAZULI, Material.RAW_IRON, Material.REDSTONE, Material.DIAMOND, Material.RAW_GOLD, Material.EMERALD,
                    Material.QUARTZ, Material.GOLD_NUGGET, Material.ANCIENT_DEBRIS
            };

    public static Material[] visualResultDeepslateTable =
            {
                    Material.DEEPSLATE_COAL_ORE, Material.DEEPSLATE_COPPER_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DEEPSLATE_IRON_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.DEEPSLATE_GOLD_ORE, Material.DEEPSLATE_EMERALD_ORE,
            };

    public static Material[] visualResultTable =
            {
                    Material.COAL_ORE, Material.COPPER_ORE, Material.LAPIS_ORE, Material.IRON_ORE, Material.REDSTONE_ORE, Material.DIAMOND_ORE, Material.GOLD_ORE, Material.EMERALD_ORE,
            };

    public static Material[] visualResultNetherTable =
            {
                    Material.NETHER_QUARTZ_ORE, Material.NETHER_GOLD_ORE, Material.ANCIENT_DEBRIS
            };

    public static Double[][] potentialTable =
            {
                    {
                        80.0, 10.0, 5.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0
                    },

                    {
                        12.0, 70.0, 7.0, 3.0, 3.0, 1.0, 2.0, 2.0, 0.0, 0.0, 0.0
                    },

                    {
                        12.0, 12.0, 65.0, 3.0, 3.0, 1.0, 2.0, 2.0, 0.0, 0.0, 0.0
                    },

                    {
                        3.0, 3.0, 3.0, 40.0, 3.0, 2.0, 3.0, 3.0, 40.0, 0.0, 0.0
                    },

                    {
                        7.0, 7.0, 7.0, 7.0, 60.0, 2.0, 5.0, 5.0, 0.0, 0.0, 0.0
                    },

                    {
                        5.0, 5.0, 4.0, 4.0, 4.0, 70.0, 4.0, 4.0, 0.0, 0.0, 0.0
                    },

                    {
                        7.0, 7.0, 5.0, 3.0, 5.0, 1.0, 60.0, 2.0, 0.0, 10.0, 0.0
                    },

                    {
                        5.0, 5.0, 5.0, 3.0, 5.0, 1.0, 6.0, 70.0, 0.0, 0.0, 0.0
                    },

                    {
                        80.0, 10.0, 5.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0
                    },

                    {
                        12.0, 70.0, 7.0, 3.0, 3.0, 1.0, 2.0, 2.0, 0.0, 0.0, 0.0
                    },

                    {
                        12.0, 12.0, 65.0, 3.0, 3.0, 1.0, 2.0, 2.0, 0.0, 0.0, 0.0
                    },

                    {
                        3.0, 3.0, 3.0, 40.0, 3.0, 2.0, 3.0, 3.0, 40.0, 0.0, 0.0
                    },

                    {
                        7.0, 7.0, 7.0, 7.0, 60.0, 2.0, 5.0, 5.0, 0.0, 0.0, 0.0
                    },

                    {
                        5.0, 5.0, 4.0, 4.0, 4.0, 70.0, 4.0, 4.0, 0.0, 0.0, 0.0
                    },

                    {
                        7.0, 7.0, 5.0, 3.0, 5.0, 1.0, 60.0, 2.0, 0.0, 10.0, 0.0
                    },

                    {
                        5.0, 5.0, 5.0, 3.0, 5.0, 1.0, 6.0, 70.0, 0.0, 0.0, 0.0
                    },




                    {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 90.0, 9.9, 0.1
                    },

                    {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 9.9, 90.0, 0.1
                    },

                    {
                        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 10.0, 10.0, 80.0
                    }

            };

    public OreBlockListener() {
        for (int i = 0; i< 19; i++) {
            OPtable.put(oreTable[i], potentialTable[i]);
        }
    }

    @EventHandler
    public static void oreBreak(BlockBreakEvent e) {
        if (!Arrays.asList(oreTable).contains(e.getBlock().getType())) return;

        ItemStack helding = e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().getHeldItemSlot());
        if (helding != null) {
            if (helding.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                return;
            }
        }

        int dupling = 1;
        if (helding != null) {
            if (helding.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
                dupling = (int) (dupling + helding.getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS)*Math.random());
            }
        }




        e.setCancelled(true);
        if (LuckingBlock.contains(e.getBlock())) {
            return;
        }

        if (Arrays.asList(visualResultTable).contains(e.getBlock().getType())) {
            RandomOreBox(e.getBlock(), visualResultTable, dupling);
            e.setDropItems(false);
        }
        if (Arrays.asList(visualResultDeepslateTable).contains(e.getBlock().getType())) {
            RandomOreBox(e.getBlock(), visualResultDeepslateTable, dupling);
            e.setDropItems(false);
        }
        if (Arrays.asList(visualResultNetherTable).contains(e.getBlock().getType())) {
            RandomOreBox(e.getBlock(), visualResultNetherTable, dupling);
            e.setDropItems(false);
        }
    }









    public static void RandomOreBox(Block block, Material[] visuals, int dupling) {
        Material item = Material.AIR;
        Double[] potentialList = OPtable.get(block.getType());
        Double getpotential = Math.random()*100;
        Double inpotential = 0.0;
        for (int i=0; i<potentialList.length; i++) {
            if (inpotential < getpotential && getpotential < (inpotential + potentialList[i])) {
                item = resultTable[i];
            }
            inpotential = inpotential + potentialList[i];
        }
        ItemStack ore = new ItemStack(item, dupling);



        int[] interval = { 1, 1, 1, 2, 2, 4, 4, 8, 8, 16, 16, 16 };
        Random random = new Random();
        LuckingBlock.add(block);
        Bukkit.getScheduler().runTaskAsynchronously(LuckySurvival.getInstance(), () -> {
            try {
                for (int i = 0; i < interval.length; i++) {
                    Bukkit.getScheduler().runTask(LuckySurvival.getInstance(), () -> {
                        block.setType(visuals[random.nextInt(visuals.length)]);
                        block.getWorld().playSound(block.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3f, 1f);
                    });
                    Thread.sleep(interval[i]*50);
                }
                Bukkit.getScheduler().runTask(LuckySurvival.getInstance(), () -> {
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), ore);
                    LuckingBlock.remove(block);
                });
            } catch (InterruptedException ignored) {}
        });

    }
}

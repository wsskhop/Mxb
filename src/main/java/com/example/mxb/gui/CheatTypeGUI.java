package com.example.mxb.gui;

import com.example.mxb.MxbPlugin;
import com.example.mxb.config.CheatType;
import com.example.mxb.util.TimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CheatTypeGUI {

    public static final String TITLE = "§8封禁菜单 - 选择作弊类型";

        private final MxbPlugin plugin;

            public CheatTypeGUI(MxbPlugin plugin) {
                    this.plugin = plugin;
                        }

                            public void open(Player player) {
                                    Inventory inv = Bukkit.createInventory(null, 54, TITLE);

                                            ItemStack filler = makeItem(Material.GRAY_STAINED_GLASS_PANE, " ", null);
                                                    for (int i = 0; i < 54; i++) inv.setItem(i, filler);

                                                            for (CheatType t : plugin.getTypeConfig().getTypes()) {
                                                                        if (t.getSlot() < 0 || t.getSlot() >= 54) continue;
                                                                                    inv.setItem(t.getSlot(), makeItem(t.getIcon(),
                                                                                                        TimeUtil.color(t.getName()), buildLore(t)));
                                                                                                                }

                                                                                                                        player.openInventory(inv);
                                                                                                                            }

                                                                                                                                private List<String> buildLore(CheatType t) {
                                                                                                                                        List<String> out = new ArrayList<>();
                                                                                                                                                for (String l : t.getLore()) {
                                                                                                                                                            out.add(TimeUtil.color(l
                                                                                                                                                                                .replace("%threshold%", String.valueOf(t.getWarnThreshold()))
                                                                                                                                                                                                    .replace("%duration%", t.getBanDuration() < 0 ? "永久"
                                                                                                                                                                                                                                : TimeUtil.formatDuration(t.getBanDuration()))));
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                return out;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                        static ItemStack makeItem(Material m, String name, List<String> lore) {
                                                                                                                                                                                                                                                                ItemStack item = new ItemStack(m);
                                                                                                                                                                                                                                                                        ItemMeta meta = item.getItemMeta();
                                                                                                                                                                                                                                                                                if (meta != null) {
                                                                                                                                                                                                                                                                                            meta.setDisplayName(name);
                                                                                                                                                                                                                                                                                                        if (lore != null) meta.setLore(lore);
                                                                                                                                                                                                                                                                                                                    item.setItemMeta(meta);
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                    return item;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        }
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
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ConfirmGUI {

    public static final String TITLE_PREFIX = "§8确认警告 - ";

        public static void open(MxbPlugin plugin, Player viewer, Player target, CheatType type) {
                Inventory inv = Bukkit.createInventory(null, 27,
                                TITLE_PREFIX + TimeUtil.color("&e" + target.getName()));

                                        ItemStack filler = CheatTypeGUI.makeItem(Material.GRAY_STAINED_GLASS_PANE, " ", null);
                                                for (int i = 0; i < 27; i++) inv.setItem(i, filler);

                                                        int count = plugin.getWarnManager().getCount(target.getUniqueId().toString(), type.getId());

                                                                ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                                                                        SkullMeta meta = (SkullMeta) head.getItemMeta();
                                                                                if (meta != null) {
                                                                                            meta.setOwningPlayer(target);
                                                                                                        meta.setDisplayName(TimeUtil.color("&e" + target.getName()));
                                                                                                                    List<String> lore = new ArrayList<>();
                                                                                                                                lore.add(TimeUtil.color("&7作弊类型: &c" + type.getName()));
                                                                                                                                            lore.add(TimeUtil.color("&7当前警告: &c" + count + "&7/&c" + type.getWarnThreshold()));
                                                                                                                                                        lore.add(TimeUtil.color("&7警告后变为: &c" + (count + 1)));
                                                                                                                                                                    if (count + 1 >= type.getWarnThreshold()) {
                                                                                                                                                                                    lore.add("");
                                                                                                                                                                                                    lore.add(TimeUtil.color("&c&l警告达到阈值, 该玩家将被封禁!"));
                                                                                                                                                                                                                }
                                                                                                                                                                                                                            meta.setLore(lore);
                                                                                                                                                                                                                                        head.setItemMeta(meta);
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                        inv.setItem(13, head);
                                                                                                                                                                                                                                                                inv.setItem(11, CheatTypeGUI.makeItem(Material.LIME_STAINED_GLASS_PANE,
                                                                                                                                                                                                                                                                                TimeUtil.color("&a&l确认警告"), null));
                                                                                                                                                                                                                                                                                        inv.setItem(15, CheatTypeGUI.makeItem(Material.RED_STAINED_GLASS_PANE,
                                                                                                                                                                                                                                                                                                        TimeUtil.color("&c&l取消"), null));

                                                                                                                                                                                                                                                                                                                viewer.openInventory(inv);
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    }
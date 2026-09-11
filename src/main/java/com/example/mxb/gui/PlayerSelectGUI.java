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

public class PlayerSelectGUI {

    public static final String TITLE_PREFIX = "§8选择玩家 - ";
        public static final int SIZE = 54;
            public static final int ITEMS_PER_PAGE = 45;

                private final MxbPlugin plugin;
                    private final CheatType cheatType;
                        private final int page;

                            public PlayerSelectGUI(MxbPlugin plugin, CheatType cheatType, int page) {
                                    this.plugin = plugin;
                                            this.cheatType = cheatType;
                                                    this.page = page;
                                                        }

                                                            public void open(Player viewer) {
                                                                    List<Player> online = new ArrayList<>(Bukkit.getOnlinePlayers());
                                                                            online.removeIf(p -> p.getUniqueId().equals(viewer.getUniqueId()));

                                                                                    int totalPages = Math.max(1, (int) Math.ceil(online.size() / (double) ITEMS_PER_PAGE));
                                                                                            int cur = Math.max(0, Math.min(page, totalPages - 1));

                                                                                                    String title = TITLE_PREFIX + TimeUtil.color(cheatType.getName())
                                                                                                                    + " §7(" + (cur + 1) + "/" + totalPages + ")";

                                                                                                                            Inventory inv = Bukkit.createInventory(null, SIZE, title);

                                                                                                                                    ItemStack filler = CheatTypeGUI.makeItem(Material.GRAY_STAINED_GLASS_PANE, " ", null);
                                                                                                                                            for (int i = 45; i < 54; i++) inv.setItem(i, filler);

                                                                                                                                                    int start = cur * ITEMS_PER_PAGE;
                                                                                                                                                            int end = Math.min(start + ITEMS_PER_PAGE, online.size());

                                                                                                                                                                    for (int i = start; i < end; i++) {
                                                                                                                                                                                Player p = online.get(i);
                                                                                                                                                                                            int count = plugin.getWarnManager().getCount(p.getUniqueId().toString(), cheatType.getId());

                                                                                                                                                                                                        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                                                                                                                                                                                                                    SkullMeta meta = (SkullMeta) head.getItemMeta();
                                                                                                                                                                                                                                if (meta != null) {
                                                                                                                                                                                                                                                meta.setOwningPlayer(p);
                                                                                                                                                                                                                                                                meta.setDisplayName(TimeUtil.color("&e" + p.getName()));
                                                                                                                                                                                                                                                                                List<String> lore = new ArrayList<>();
                                                                                                                                                                                                                                                                                                lore.add(TimeUtil.color("&7当前警告: &c" + count + "&7/&c" + cheatType.getWarnThreshold()));
                                                                                                                                                                                                                                                                                                                lore.add("");
                                                                                                                                                                                                                                                                                                                                lore.add(TimeUtil.color("&a点击 -> 警告该玩家"));
                                                                                                                                                                                                                                                                                                                                                meta.setLore(lore);
                                                                                                                                                                                                                                                                                                                                                                head.setItemMeta(meta);
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        inv.setItem(i - start, head);
                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                        if (cur > 0) inv.setItem(45, CheatTypeGUI.makeItem(Material.ARROW, TimeUtil.color("&a上一页"), null));
                                                                                                                                                                                                                                                                                                                                                                                                                if (cur < totalPages - 1) inv.setItem(53, CheatTypeGUI.makeItem(Material.ARROW, TimeUtil.color("&a下一页"), null));
                                                                                                                                                                                                                                                                                                                                                                                                                        inv.setItem(49, CheatTypeGUI.makeItem(Material.BARRIER, TimeUtil.color("&c返回作弊类型"), null));

                                                                                                                                                                                                                                                                                                                                                                                                                                viewer.openInventory(inv);
                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                    }
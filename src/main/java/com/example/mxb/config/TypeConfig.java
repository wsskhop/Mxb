package com.example.mxb.config;

import com.example.mxb.util.TimeUtil;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;

public class TypeConfig {

    private final Map<String, CheatType> types = new LinkedHashMap<>();

        public TypeConfig(JavaPlugin plugin) {
                File file = new File(plugin.getDataFolder(), "type.yml");
                        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                                ConfigurationSection sec = cfg.getConfigurationSection("cheat-types");
                                        if (sec == null) {
                                                    plugin.getLogger().warning("type.yml 中没有 cheat-types 节点");
                                                                return;
                                                                        }

                                                                                int idx = 0;
                                                                                        for (String id : sec.getKeys(false)) {
                                                                                                    ConfigurationSection s = sec.getConfigurationSection(id);
                                                                                                                if (s == null) continue;

                                                                                                                            String name = s.getString("name", id);

                                                                                                                                        Material icon;
                                                                                                                                                    try {
                                                                                                                                                                    icon = Material.valueOf(s.getString("icon", "PAPER").toUpperCase());
                                                                                                                                                                                } catch (IllegalArgumentException e) {
                                                                                                                                                                                                icon = Material.PAPER;
                                                                                                                                                                                                            }

                                                                                                                                                                                                                        int slot = s.getInt("slot", idx);
                                                                                                                                                                                                                                    List<String> lore = s.getStringList("lore");
                                                                                                                                                                                                                                                int threshold = s.getInt("warn-threshold", 3);
                                                                                                                                                                                                                                                            long duration = TimeUtil.parseDuration(s.getString("ban-duration", "7d"));
                                                                                                                                                                                                                                                                        String reason = s.getString("reason", name);

                                                                                                                                                                                                                                                                                    types.put(id, new CheatType(id, name, icon, slot, lore, threshold, duration, reason));
                                                                                                                                                                                                                                                                                                idx++;
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                public Collection<CheatType> getTypes() { return types.values(); }

                                                                                                                                                                                                                                                                                                                    public CheatType getType(String id) { return types.get(id); }

                                                                                                                                                                                                                                                                                                                        public CheatType getBySlot(int slot) {
                                                                                                                                                                                                                                                                                                                                for (CheatType t : types.values()) if (t.getSlot() == slot) return t;
                                                                                                                                                                                                                                                                                                                                        return null;
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                            }
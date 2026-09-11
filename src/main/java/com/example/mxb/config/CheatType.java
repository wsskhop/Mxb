package com.example.mxb.config;

import org.bukkit.Material;

import java.util.List;

public class CheatType {
    private final String id;
        private final String name;
            private final Material icon;
                private final int slot;
                    private final List<String> lore;
                        private final int warnThreshold;
                            private final long banDuration;
                                private final String reason;

                                    public CheatType(String id, String name, Material icon, int slot, List<String> lore,
                                                         int warnThreshold, long banDuration, String reason) {
                                                                 this.id = id;
                                                                         this.name = name;
                                                                                 this.icon = icon;
                                                                                         this.slot = slot;
                                                                                                 this.lore = lore;
                                                                                                         this.warnThreshold = warnThreshold;
                                                                                                                 this.banDuration = banDuration;
                                                                                                                         this.reason = reason;
                                                                                                                             }

                                                                                                                                 public String getId() { return id; }
                                                                                                                                     public String getName() { return name; }
                                                                                                                                         public Material getIcon() { return icon; }
                                                                                                                                             public int getSlot() { return slot; }
                                                                                                                                                 public List<String> getLore() { return lore; }
                                                                                                                                                     public int getWarnThreshold() { return warnThreshold; }
                                                                                                                                                         public long getBanDuration() { return banDuration; }
                                                                                                                                                             public String getReason() { return reason; }
                                                                                                                                                             }
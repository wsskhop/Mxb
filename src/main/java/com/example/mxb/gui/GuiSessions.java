package com.example.mxb.gui;

import com.example.mxb.config.CheatType;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GuiSessions {
    public static final Map<UUID, CheatType> SELECTED_TYPE = new ConcurrentHashMap<>();
        public static final Map<UUID, UUID> TARGET = new ConcurrentHashMap<>();

            public static void clear(UUID uuid) {
                    SELECTED_TYPE.remove(uuid);
                            TARGET.remove(uuid);
                                }
                                }
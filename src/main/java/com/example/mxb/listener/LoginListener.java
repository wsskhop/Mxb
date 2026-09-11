package com.example.mxb.listener;

import com.example.mxb.MxbPlugin;
import com.example.mxb.data.Ban;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.List;

public class LoginListener implements Listener {

    private final MxbPlugin plugin;

        public LoginListener(MxbPlugin plugin) {
                this.plugin = plugin;
                    }

                        @EventHandler(priority = EventPriority.HIGHEST)
                            public void onLogin(PlayerLoginEvent event) {
                                    if (event.getResult() != PlayerLoginEvent.Result.ALLOWED) return;

                                            Ban ban = plugin.getBanManager().getActiveBan(event.getPlayer().getUniqueId());
                                                    if (ban == null) return;

                                                            List<String> lines = plugin.getConfig().getStringList("kick-screen");
                                                                    String screen = plugin.getBanManager().buildScreen(
                                                                                    lines,
                                                                                                    event.getPlayer().getName(),
                                                                                                                    ban.getReason(),
                                                                                                                                    ban.getCheatTypeName() == null ? ban.getCheatType() : ban.getCheatTypeName(),
                                                                                                                                                    ban.getOperatorName(),
                                                                                                                                                                    ban.getEndTime());

                                                                                                                                                                            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, screen);
                                                                                                                                                                                }
                                                                                                                                                                                }
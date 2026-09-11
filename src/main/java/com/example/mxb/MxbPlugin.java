package com.example.mxb;

import com.example.mxb.command.MxbCommand;
import com.example.mxb.config.TypeConfig;
import com.example.mxb.gui.GUIListener;
import com.example.mxb.listener.LoginListener;
import com.example.mxb.manager.BanManager;
import com.example.mxb.manager.WarnManager;
import com.example.mxb.storage.Database;
import org.bukkit.plugin.java.JavaPlugin;

public class MxbPlugin extends JavaPlugin {

    private static MxbPlugin instance;

        private Database database;
            private TypeConfig typeConfig;
                private BanManager banManager;
                    private WarnManager warnManager;

                        @Override
                            public void onEnable() {
                                    instance = this;

                                            saveDefaultConfig();
                                                    saveResource("type.yml", false);

                                                            typeConfig = new TypeConfig(this);

                                                                    database = new Database(this);
                                                                            database.init();

                                                                                    banManager = new BanManager(this);
                                                                                            warnManager = new WarnManager(this);

                                                                                                    var cmd = getCommand("mxb");
                                                                                                            if (cmd != null) {
                                                                                                                        MxbCommand executor = new MxbCommand(this);
                                                                                                                                    cmd.setExecutor(executor);
                                                                                                                                                cmd.setTabCompleter(executor);
                                                                                                                                                        }

                                                                                                                                                                getServer().getPluginManager().registerEvents(new LoginListener(this), this);
                                                                                                                                                                        getServer().getPluginManager().registerEvents(new GUIListener(this), this);

                                                                                                                                                                                getLogger().info("Mxb 已启用, 已加载 " + typeConfig.getTypes().size() + " 种作弊类型");
                                                                                                                                                                                    }

                                                                                                                                                                                        @Override
                                                                                                                                                                                            public void onDisable() {
                                                                                                                                                                                                    if (database != null) database.close();
                                                                                                                                                                                                            getLogger().info("Mxb 已关闭");
                                                                                                                                                                                                                }

                                                                                                                                                                                                                    public static MxbPlugin getInstance() { return instance; }
                                                                                                                                                                                                                        public Database getDatabase() { return database; }
                                                                                                                                                                                                                            public TypeConfig getTypeConfig() { return typeConfig; }
                                                                                                                                                                                                                                public BanManager getBanManager() { return banManager; }
                                                                                                                                                                                                                                    public WarnManager getWarnManager() { return warnManager; }
                                                                                                                                                                                                                                    }
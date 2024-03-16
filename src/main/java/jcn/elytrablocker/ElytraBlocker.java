package jcn.elytrablocker;

import jcn.elytrablocker.listeners.PlayerMove;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public final class ElytraBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        File dataFolder = getDataFolder();
        if (!dataFolder.exists()){
            dataFolder.mkdir();
        }

        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveDefaultConfig();
        }

        List<String> blockedWorlds = getConfig().getStringList("block-elytra-worlds");

        getServer().getPluginManager().registerEvents(new PlayerMove(blockedWorlds), this);
    }

    @Override
    public void onDisable() {
    }
}

package jcn.elytrablocker.listeners;

import jcn.elytrablocker.ElytraBlocker;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class PlayerMove implements Listener {
    private final List<String> blockedWorlds;
    public PlayerMove(List<String> blockedWorlds){
        this.blockedWorlds = blockedWorlds;
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (player.isGliding() && blockedWorlds.contains(player.getWorld().getName())){
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Элитры отключены в этом мире"));
            player.setGliding(false);

        }
    }
}

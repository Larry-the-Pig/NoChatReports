package me.teakivy.nochatreports.listeners;

import me.teakivy.nochatreports.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (Config.isPaperWorkaround()) {
            e.setCancelled(true);

            String message = String.format(e.getFormat(), e.getPlayer().getDisplayName(), e.getMessage());

            Bukkit.getConsoleSender().sendMessage(message);
            for (Player toPlayer : Bukkit.getOnlinePlayers()) {
                toPlayer.sendMessage(message);
            }

            return;
        }
        e.setMessage(e.getMessage() + " ");
    }
}

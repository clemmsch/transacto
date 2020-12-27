package me.panem.transacto.listeners;

import me.panem.transacto.utils.BasicUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        /*
        * This one is going to be more complex
        * It is responsible for checking if
        * a player is already "signed-up" to the database
        * Since we do this like that, we will avoid any complications
        * regarding not existing Players when they decide to do their first payment.
        * */
        Player player = event.getPlayer();
        BasicUtils utils = new BasicUtils();
        utils.isPlayerInDatabase(player);
        // TODO Make this happen
    }
}
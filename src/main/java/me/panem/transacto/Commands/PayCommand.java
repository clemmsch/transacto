package me.panem.transacto.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.GameRuleCommand;
import org.bukkit.entity.Player;
import me.panem.transacto.Utils.BasicUtils;

import java.lang.reflect.Array;

public class PayCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            // TODO Make better
            BasicUtils utils = new BasicUtils();
            Player player = (Player) sender;
            // Does the player have enough money?
            if (utils.DoesPlayerHaveEnoughMoney(player, 0))
            {
                // Are there enough arguments? We do not want it to be able to not sender any money
                if (args.length < 2) {
                    player.sendMessage("§cPlease use §6/pay §e<player> §a<amount>");
                } else if (args.length == 2) {
                    // Extract the values
                    Player target = Bukkit.getPlayer(args[0]);
                    // Does the player have a value?
                    if (target != null) {
                        // The target is not null, this is very good, isnt it?

                        // Now we have to extract the amount
                        int amount = utils.GetIntFromArgs(args, 1);
                        // But it is not allowed to be below 0, remember that.
                        if (amount <= 0) {
                            player.sendMessage("§cPlease enter a valid amount");
                        } else {
                            target.sendMessage("§9" + player.getName() + "§a has given you §6" + amount + "£");
                            player.sendMessage("§9You §a have given §b" + target.getName() + " §6" + amount + "£");
                        }
                    } else {
                        player.sendMessage("§4" + args[0] + "§c is not online.");
                    }
                } else {
                    player.sendMessage("§cPlease use §6/pay §e<player> §a<amount>");
                }
            } else {
                player.sendMessage("§cYou do not have enough money to do this!");
            }
        } else {
            sender.sendMessage("§c[Transacto] This command can only be used by players");
        }




        return true;
    }
}

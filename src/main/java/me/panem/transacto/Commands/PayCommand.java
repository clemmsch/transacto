package me.panem.transacto.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.GameRuleCommand;
import org.bukkit.entity.Player;
import me.panem.transacto.Utils.BasicUtils;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
                        /*
                        * This function will parse an integer from the arguments
                        * Using the Integer.ParseInt() function (built-in)
                        * This is done in a "try-catch" statement which will
                        * return -1 if the argument at position 1 (Arrays start at 0)
                        * is a String / Any other value than an integer. Using a function
                        * like this (GetIntFromArgs) will prevent the program from making an
                        * error if the player inputs a string.*/
                        int amount = utils.GetIntFromArgs(args, 1);
                        // But it is not allowed to be below 0, remember that.
                        if (amount <= 0) {
                            player.sendMessage("§cPlease enter a valid amount (Positive Integer)");
                        } else {
                            // This is the main loop of the pay command. It will create the inventory and handle
                            // all of the logic concerning inventories, etc.
                            ////////////////////////////////////////////////////////////////////////////////////////

                            // Creating the inventory
                            Inventory inventory = Bukkit.createInventory(null /* FIXME Change this*/, 9 * 4, "§6Review your transaction");

                            // All "beautifications" to the inventory should be made here

                            // The yellow glass
                            /* TODO Not really a TODO, just a value of Things :)
                            *0 White Stained Glass Pane
                            *
                            1 Orange Stained Glass Pane

                            2 Magenta Stained Glass Pane

                            3 Light Blue Stained Glass Pane

                            4 Yellow Stained Glass Pane

                            5 Lime Stained Glass Pane

                            6 Pink Stained Glass Pane

                            7 Gray Stained Glass Pane

                            8 Light Gray Stained Glass Pane

                            9 Cyan Stained Glass Pane

                            10 Purple Stained Glass Pane

                            11 Blue Stained Glass Pane

                            12 Brown Stained Glass Pane

                            13 Green Stained Glass Pane

                            14 Red Stained Glass Pane

                            15 Black Stained Glass Pane
                            */

                            // Setting up the glass (Default values)
                            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
                            ItemMeta glassMeta = glass.getItemMeta();
                            glassMeta.setDisplayName("§f§lBORDER");
                            glass.setItemMeta(glassMeta);

                            // Setting up the confirm dye (Default values)
                            ItemStack confirmDye = new ItemStack(Material.INK_SACK, 1, (byte) 10);
                            ItemMeta confirmDyeMeta = glass.getItemMeta();
                            confirmDyeMeta.setDisplayName("§a§lCONFIRM");
                            confirmDye.setItemMeta(confirmDyeMeta);

                            // Setting up the decline dye (Default values)
                            ItemStack declineDye = new ItemStack(Material.INK_SACK, 1, (byte) 1);
                            ItemMeta declineDyeMeta = glass.getItemMeta();
                            declineDyeMeta.setDisplayName("§c§lDECLINE");
                            declineDye.setItemMeta(declineDyeMeta);






                            // Adding the items to it, pls do not
                            // I know that this is a horrible way of adding things, i will FIXME later if I find another way

                            /////////////////////////////// THE "BORDER" GLASS ///////////////////////////////

                            // THE FIRST HORIZONTAL ROW
                            inventory.setItem(0, glass);
                            inventory.setItem(1, glass);
                            inventory.setItem(2, glass);
                            inventory.setItem(3, glass);
                            inventory.setItem(4, glass);
                            inventory.setItem(5, glass);
                            inventory.setItem(6, glass);
                            inventory.setItem(7, glass);
                            inventory.setItem(8, glass);

                            // THE LEFT VERTICAL ROW
                            inventory.setItem(9, glass);
                            inventory.setItem(18, glass);
                            inventory.setItem(27, glass);

                            // THE LAST HORIZONTAL ROW
                            inventory.setItem(28, glass);
                            inventory.setItem(29, glass);
                            inventory.setItem(30, confirmDye);
                            inventory.setItem(31, glass);
                            inventory.setItem(32, declineDye);
                            inventory.setItem(33, glass);
                            inventory.setItem(34, glass);
                            inventory.setItem(35, glass);

                            // THE RIGHT VERTICAL ROW
                            inventory.setItem(17, glass);
                            inventory.setItem(26, glass);


                            ////////////////////////////////////// SETTING THE DYE (CONFIRM & CANCEL) /////////////////////////////////////////


                            // Here we open it, after this no changes to the inventory can be made
                            player.openInventory(inventory);
                            player.sendMessage("§aPlease review your transaction");

                            target.sendMessage("§b" + player.getName() + "§a has begun the transaction process with you.");





















                            //////////////////////////////////////////////////////////////////////////////////////////
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

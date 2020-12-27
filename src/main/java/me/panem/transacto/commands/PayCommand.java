package me.panem.transacto.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.panem.transacto.utils.BasicUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class PayCommand implements CommandExecutor, Listener // We need the listener to cancel any GUI events while the inventory is open
{



    // This is the title of the Review-And-Confirm-Your-Transaction Screen (I need this in a Listener, thats why its here)
    private final String GUI_NAME = "§6Review your transaction";
    // I need them too
    private Player player;
    private Player target;
    private int amount;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            // TODO Make better
            BasicUtils utils = new BasicUtils();
            player = (Player) sender;
            // Does the player have enough money?
            if (utils.doesPlayerHaveEnoughMoney(player, 0))
            {
                // Are there enough arguments? We do not want it to be able to not sender any money
                if (args.length < 2) {
                    player.sendMessage("§cPlease use §6/pay §e<player> §a<amount>");
                } else if (args.length == 2) {
                    // Extract the values
                    target = Bukkit.getPlayer(args[0]);
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
                        amount = utils.getIntFromArgs(args, 1);
                        // But it is not allowed to be below 0, remember that.
                        if (amount <= 0) {
                            player.sendMessage("§cPlease enter a valid amount (Positive Integer)");
                        } else {
                            // This is the main loop of the pay command. It will create the inventory and handle
                            // all of the logic concerning inventories, etc.
                            ////////////////////////////////////////////////////////////////////////////////////////

                            // Creating the inventory
                            Inventory inventory = Bukkit.createInventory(null, 9 * 4, GUI_NAME);

                            // All "beautifications" to the inventory should be made here

                            // Setting up the glass (Default values)
                            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
                            ItemMeta glassMeta = glass.getItemMeta();
                            glassMeta.setDisplayName("§f§lBORDER");
                            glass.setItemMeta(glassMeta);

                            // Setting up the confirm dye (Default values)
                            ItemStack confirmDye = new ItemStack(Material.WOOL, 1, (short) 10);
                            ItemMeta confirmDyeMeta = glass.getItemMeta();
                            confirmDyeMeta.setDisplayName("§a§lCONFIRM");
                            confirmDye.setItemMeta(confirmDyeMeta);

                            // Setting up the decline dye (Default values)
                            ItemStack barrier = new ItemStack(Material.BARRIER);
                            ItemMeta barrierMeta = glass.getItemMeta();
                            barrierMeta.setDisplayName("§c§lCANCEL");
                            barrier.setItemMeta(barrierMeta);


                            // Setting up the player heads dye (Default values)
                            ItemStack playerSkull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

                            // A few defaults
                            SkullMeta playerSkullMeta = (SkullMeta) playerSkull.getItemMeta();
                            playerSkullMeta.setOwner(player.getName());
                            playerSkullMeta.setDisplayName("§b" + player.getName());
                            playerSkullMeta.setLore(Arrays.asList("§b§lFROM"));

                            playerSkull.setItemMeta(playerSkullMeta);

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
                            inventory.setItem(32, barrier);
                            inventory.setItem(33, glass);
                            inventory.setItem(34, glass);
                            inventory.setItem(35, glass);

                            // THE RIGHT VERTICAL ROW
                            inventory.setItem(17, glass);
                            inventory.setItem(26, glass);

                            // THINGS IN THE MIDDLE
                            // The heads
                            inventory.setItem(12, playerSkull);


                            // Now we need the targets settings for our meta :)
                            playerSkullMeta.setOwner(target.getName());
                            playerSkullMeta.setDisplayName("§e" + target.getName());
                            playerSkullMeta.setLore(Arrays.asList("§e§lTO"));

                            playerSkull.setItemMeta(playerSkullMeta);

                            inventory.setItem(14, playerSkull);

                            // Now we just need the arrow that will signify in what direction the player will go
                            playerSkullMeta.setOwner("MHF_ArrowRight");
                            playerSkullMeta.setDisplayName("§f->");
                            playerSkullMeta.setLore(Arrays.asList("§f§l->"));

                            playerSkull.setItemMeta(playerSkullMeta);

                            inventory.setItem(13, playerSkull);


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

    // I know that this should be in an extra file, but it is tied to the PayCommand VERY heavily, and I do not want very static things like this to be counted
    // as an actual "Serverwide Listener"
    @EventHandler
    public void onPayReviewerGUIClick(@NotNull InventoryClickEvent event)
    { /*PayReviewer is the GUI that opens when we use /pay */
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player _player = (Player) event.getWhoClicked();
        // Is the inventory in what the click happaned even the pay reviewer?
        if(event.getClickedInventory().getTitle().equals(GUI_NAME)) {
            event.setCancelled(true);
            switch(event.getCurrentItem().getType()) {
                case STAINED_GLASS_PANE:
                    break;
                case WOOL:
                    doTransaction(_player, target, amount);
                    _player.closeInventory();
                    break;
                case BARRIER:
                    _player.sendMessage("§cYou have cancelled the transaction process");
                    _player.closeInventory();
                    break;
                default:
                    break;
            }
        } // We truly do not care about anything if it isnt our inv
    }


    /*
    * I am doing this in an extra function
    * since I may want to be able to call this
    * function outside of PayCommand without
    * opening the GUI, this will simply be what happens
    * if the player presses transact.*/
    public void doTransaction(@NotNull Player player, @NotNull Player target, int amount) {
        player.sendMessage("§aYou have successfully given §6" + Integer.toString(amount) + " §ato §e" + target.getName());
    }


}

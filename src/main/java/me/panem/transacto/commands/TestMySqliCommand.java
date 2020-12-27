package me.panem.transacto.commands;

import me.panem.transacto.utils.MysqliConnectionHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestMySqliCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // I am doing this since I want both the player and the console to be able to
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("transacto.test.mysqli")) {
                testMysqliConnectionImplementation(sender);
            }
        } else {
            // It is a console which means that we do not have to do permission checks :)
            testMysqliConnectionImplementation(sender);
        }
        return true;
    }

    private void testMysqliConnectionImplementation(CommandSender sender) {
        /* This will either return true if it did not fail or false if it has failed.*/
        MysqliConnectionHandler handler = new MysqliConnectionHandler();
        if (handler.testMysqliConnection()) {
            // It has not failed
            // TODO (!!!!) REMOVE THIS THIS IS VERY DANGEROUS!!!!!!!!
            sender.sendMessage("§6§lTransacto-Mysqli-Connection-Tester: \n §aSuccessfully connected!");
            sender.sendMessage("§6 Host: " + handler.getMysqliHost());
            sender.sendMessage("§b Username: " + handler.getMysqliUsername());
            sender.sendMessage("§e Password: " + handler.getMysqliPassword());
            sender.sendMessage("§3 Port: " + handler.getMysqliPort());
            sender.sendMessage("§4 Socket: " + handler.getMysqliSocket());
            sender.sendMessage("§4 Dbname: " + handler.getMysqliDbname());

        } else {
            sender.sendMessage("§6§lTransacto-Mysqli-Connection-Tester: \n §cFailed to connect!");
        }
    }
}


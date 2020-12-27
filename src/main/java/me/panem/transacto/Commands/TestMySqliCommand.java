package me.panem.transacto.Commands;

import me.panem.transacto.Utils.MysqliConnectionHandler;
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
                TestMysqliConnectionImplementation(sender);
            }
        } else {
            // It is a console which means that we do not have to do permission checks :)
            TestMysqliConnectionImplementation(sender);
        }
        return true;
    }

    private void TestMysqliConnectionImplementation(CommandSender sender) {
        /* This will either return true if it did not fail or false if it has failed.*/
        MysqliConnectionHandler handler = new MysqliConnectionHandler();
        if (handler.TestMysqliConnection()) {
            // It has not failed
            // TODO (!!!!) REMOVE THIS THIS IS VERY DANGEROUS!!!!!!!!
            sender.sendMessage("§6§lTransacto-Mysqli-Connection-Tester: \n §aSuccessfully connected!");
            sender.sendMessage("§6 Host: " + handler.getMysqliHost());
            sender.sendMessage("§b Username: " + handler.getMysqliUsername());
            sender.sendMessage("§e Password: " + handler.getMysqliPassword());
            sender.sendMessage("§3 Port: " + handler.getMysqliPort());
            sender.sendMessage("§4 Socket: " + handler.getMysqliSocket());

        } else {
            sender.sendMessage("§6§lTransacto-Mysqli-Connection-Tester: \n §cFailed to connect!");
        }
    }
}


package me.panem.transacto.utils;

import org.bukkit.entity.Player;

public class BasicUtils
{
    public boolean doesPlayerHaveEnoughMoney(Player player, int amount)
    {
        // TODO Add Functionality
        return true;
    }

    public int getIntFromArgs(String[] args, int index)
    {
        int result;
        String stringValue = args[index];
        int foo;
        // Try a few things
        try {
            foo = Integer.parseInt(stringValue);
        } catch (NumberFormatException e) {
            foo = -1;
        }

        result = foo;
        return result;
    }

    //TODO Add functionality
    public boolean isPlayerInDatabase(Player player) {
        return true;
    }

}

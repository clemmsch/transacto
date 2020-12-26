package me.panem.transacto.Utils;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.entity.Player;

public class BasicUtils
{
    public boolean DoesPlayerHaveEnoughMoney(Player player, int amount)
    {
        // TODO Add Functionality
        return true;
    }

    public int GetIntFromArgs(String[] args, int index)
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
}

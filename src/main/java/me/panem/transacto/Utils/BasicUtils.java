package me.panem.transacto.Utils;

import com.avaje.ebean.validation.NotNull;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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

    //TODO Add functionality
    public boolean IsPlayerInDatabase(Player player) {
        return true;
    }

}

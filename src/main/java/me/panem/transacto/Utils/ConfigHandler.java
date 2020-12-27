package me.panem.transacto.Utils;

import me.panem.transacto.Transacto;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler
{
    public void setConfigurationFileToDefaultValues() {
        // We want the config here, all of the values are going to be in the config :)
        FileConfiguration config = Transacto.getPlugin().getConfig();
        config.set("Transacto.MySqli.Host", "YOUR MYSQLI HOST");
        config.set("Transacto.MySqli.Username", "YOUR MYSQLI USERNAME");
        config.set("Transacto.MySqli.Password", "YOUR MYSQLI PASSWORD");
        config.set("Transacto.MySqli.Port", "YOUR MYSQLI PORT");
        config.set("Transacto.MySqli.Socket", "YOUR MYSQLI SOCKET");
        Transacto.getPlugin().saveConfig();
    }

    public void InititalizeAllValuesToBeSetToValuesFromConfigurationFile() {

    }
}

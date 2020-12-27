package me.panem.transacto.utils;

import me.panem.transacto.Transacto;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler
{
    public void setConfigurationFileToDefaultValues() {
        // We want the config here, all of the values are going to be in the config :)
        FileConfiguration config = Transacto.getPlugin().getConfig();
        config.set("Transacto.MySqli.Host", "localhost"); // Default XAMPP Host
        config.set("Transacto.MySqli.Username", "root"); // Default XAMPP Username
        config.set("Transacto.MySqli.Password", ""); // Default XAMPP Password
        config.set("Transacto.MySqli.Port", "3306"); // Default XAMPP Port
        config.set("Transacto.MySqli.Socket", ""); // Default XAMPP Socket (Nonexistent)
        config.set("Transacto.MySqli.Dbname", "transacto"); // My Database in the localhost
        Transacto.getPlugin().saveConfig();
    }

    public void initializeAllValuesToBeSetToValuesFromConfigurationFile() {
        FileConfiguration config = Transacto.getPlugin().getConfig();

        // Mysqli Values
        MysqliConnectionHandler handler = new MysqliConnectionHandler();
        handler.setMysqliHost(config.getString("Transacto.MySqli.Host"));
        handler.setMysqliUsername(config.getString("Transacto.MySqli.Username"));
        handler.setMysqliPassword(config.getString("Transacto.MySqli.Password"));
        handler.setMysqliPort(config.getString("Transacto.MySqli.Port"));
        handler.setMysqliSocket(config.getString("Transacto.MySqli.Socket"));
        handler.setMysqliDbname(config.getString("Transacto.MySqli.Dbname"));
    }
}

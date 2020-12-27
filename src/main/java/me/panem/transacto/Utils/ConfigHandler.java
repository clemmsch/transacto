package me.panem.transacto.Utils;

import me.panem.transacto.Transacto;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler
{
    public void setConfigurationFileToDefaultValues() {
        // We want the config here, all of the values are going to be in the config :)
        FileConfiguration config = Transacto.getPlugin().getConfig();
        config.set("Transacto.MySqli.Host", "localhost");
        config.set("Transacto.MySqli.Username", "admin");
        config.set("Transacto.MySqli.Password", "1234");
        config.set("Transacto.MySqli.Port", "21");
        config.set("Transacto.MySqli.Socket", "socket");
        Transacto.getPlugin().saveConfig();
    }

    public void InitializeAllValuesToBeSetToValuesFromConfigurationFile() {
        FileConfiguration config = Transacto.getPlugin().getConfig();

        // Mysqli Values
        MysqliConnectionHandler handler = new MysqliConnectionHandler();
        handler.setMysqliHost(config.getString("Transacto.MySqli.Host"));
        handler.setMysqliUsername(config.getString("Transacto.MySqli.Username"));
        handler.setMysqliPassword(config.getString("Transacto.MySqli.Password"));
        handler.setMysqliPort(config.getInt("Transacto.MySqli.Port"));
        handler.setMysqliSocket(config.getString("Transacto.MySqli.Socket"));
    }
}

package me.panem.transacto;

import me.panem.transacto.Commands.PayCommand;
import me.panem.transacto.Commands.TransactoCommand;
import me.panem.transacto.Listeners.JoinListener;
import me.panem.transacto.Commands.TestMySqliCommand;
import me.panem.transacto.Utils.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Transacto extends JavaPlugin
{
    private static Transacto plugin;
    @Override
    public void onEnable()
    {
        plugin = this;
        FileConfiguration config = plugin.getConfig();
        // Only create the config if it does not exist!
        ConfigHandler conhan = new ConfigHandler();
        if(!config.contains("Transacto.MySqli.Host")) {
            getLogger().info(("Creating Configuration file..."));
            conhan.setConfigurationFileToDefaultValues();
        }
        // While we only want the config to be created once, we want the values to be set every single time
        conhan.InitializeAllValuesToBeSetToValuesFromConfigurationFile();

        getLogger().log(Level.FINE, "Enabling Transacto");
        // Listeners
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), plugin);

        // Commands
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("transacto").setExecutor(new TransactoCommand());
        getCommand("testmysqli").setExecutor(new TestMySqliCommand());

    }

    @Override
    public void onDisable()
    {
        getLogger().log(Level.SEVERE, "Disabling Transacto");
    }

    // Getter for Plugin
    public static Transacto getPlugin() {
        return plugin;
    }
}

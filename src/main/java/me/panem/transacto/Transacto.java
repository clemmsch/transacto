package me.panem.transacto;

import me.panem.transacto.Commands.PayCommand;
import me.panem.transacto.Commands.TransactoCommand;
import me.panem.transacto.Listeners.TransactoJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Transacto extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        getLogger().log(Level.FINE, "Enabling Transacto");
        // Listeners
        getServer().getPluginManager().registerEvents(new TransactoJoinListener(), this);

        // Commands
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("transacto").setExecutor(new TransactoCommand());

    }

    @Override
    public void onDisable()
    {
        getLogger().log(Level.SEVERE, "Disabling Transacto");
    }
}

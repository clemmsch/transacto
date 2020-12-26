package me.panem.transacto;

import me.panem.transacto.Commands.TransactoCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Transacto extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        getCommand("transacto").setExecutor(new TransactoCommand());

    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}

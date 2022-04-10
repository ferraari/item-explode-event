package ferrari.github;

import ferrari.github.commands.GetDiamond;
import ferrari.github.events.DropItemEven;
import ferrari.github.events.ExplosionEvent;
import ferrari.github.events.RightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("pegardiamante").setExecutor(new GetDiamond());
        getServer().getPluginManager().registerEvents(new ExplosionEvent(), this);
        getServer().getPluginManager().registerEvents(new DropItemEven(), this);
        getServer().getPluginManager().registerEvents(new RightClickEvent(), this);
        Bukkit.getConsoleSender().sendMessage("§aFerrari has been Plugin Enabled!");

    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}

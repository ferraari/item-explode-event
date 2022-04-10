package ferrari.github.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class DropItemEven implements Listener {

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        ItemStack is = new ItemStack(Material.DIAMOND);
        ItemMeta isMeta = is.getItemMeta();
        isMeta.setDisplayName(ChatColor.AQUA + "Diamante Explosivo");
        is.setItemMeta(isMeta);

        if(event.getItemDrop().getItemStack().equals(is)) {


            event.setCancelled(true);
            Player player = event.getPlayer();
            player.getWorld().createExplosion(player.getLocation(), 4F, false);
            player.sendMessage("§cHey, §a" + player.getDisplayName() + "§c, Você explodiu o diamante!");


        }
    }
}
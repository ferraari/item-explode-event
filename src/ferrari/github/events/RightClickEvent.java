package ferrari.github.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.BlockIterator;

import java.util.ArrayList;

public class RightClickEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        ItemStack is = new ItemStack(Material.DIAMOND);
        ItemMeta isMeta = is.getItemMeta();
        isMeta.setDisplayName(ChatColor.AQUA + "Diamante Explosivo");
        is.setItemMeta(isMeta);
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (player.getInventory().getItemInHand().equals(is)) {
                Location eyePos = player.getEyeLocation();
                BlockIterator raytracer = new BlockIterator(eyePos, 0.0D, 32);
                while (raytracer.hasNext()) {
                    Location location = raytracer.next().getLocation();
                    if (player.getWorld().getBlockAt(location).getType() != Material.AIR && !player.getWorld().getBlockAt(location).isLiquid()) {
                        player.getWorld().createExplosion(location, 5f);
                        player.sendMessage(ChatColor.GREEN + "Uow, que explosão");
                        return;
                    }
                }
            }

        }
    }
}
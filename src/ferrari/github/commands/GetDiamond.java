package ferrari.github.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetDiamond implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {
        Player p = (Player) Sender;
        ItemStack is = new ItemStack(Material.DIAMOND);
        ItemMeta isMeta = is.getItemMeta();
        isMeta.setDisplayName(ChatColor.AQUA + "Diamante Explosivo");
        is.setItemMeta(isMeta);
        if (cmd.getName().equalsIgnoreCase("pegardiamante")) {
            p.setItemInHand(is);
        }
        return true;
    }
}

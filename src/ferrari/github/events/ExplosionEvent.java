package ferrari.github.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ExplosionEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent event)
    {
        if(event.getRightClicked() instanceof Pig)
        {
            Player player = event.getPlayer();
            Pig pig = (Pig) event.getRightClicked();
            pig.getWorld().createExplosion(pig.getLocation(), 30F, true);
            player.sendMessage("§aBOOM! Parabéns §e" + player.getDisplayName() + " §avocê sabe como explodir um porco!");



        }
        return;
    }



}

package com.github.saidred.spigotTestPlugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotTestPlugin extends JavaPlugin {
  public static JavaPlugin plugin;
  public SpigotTestPlugin(){plugin = this;}

  @Override
  public void onEnable() {
    // イベントサンプル
    getServer().getPluginManager().registerEvents(new testEvent(),this);
//    getServer().getPluginManager().registerEvents(new onPlayerInteract(),this);
    // コマンドサンプル
    getCommand("test").setExecutor(new testCommand());
  }

  public class testEvent implements Listener{
    @EventHandler
    public void onEvent(BlockPlaceEvent event){
      getLogger().info("<< EVENT TEST LOG START >>");
      // テストイベント
      getLogger().info("<< EVENT TEST LOG END >>");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
      try{
        ItemStack itemMainHand = event.getItem();
        ItemStack item = new ItemStack(Material.FIREWORK_ROCKET);
        ((FireworkMeta)item.getItemMeta()).setPower(1);
        FireworkMeta fireworkMeta = (FireworkMeta) itemMainHand.getItemMeta();
        plugin.getLogger().info("isSimilarPower1:" + itemMainHand.isSimilar(item));
      } catch (Exception e) {

      }
    }
  }
  public static class testCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
      plugin.getLogger().info("<< COMMAND TEST LOG START >>");
      // テストコマンド
      plugin.getLogger().info("<< COMMAND TEST LOG END >>");
      return true;
    }
  }
}

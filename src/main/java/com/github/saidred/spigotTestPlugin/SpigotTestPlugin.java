package com.github.saidred.spigotTestPlugin;

import java.util.ArrayList;
import java.util.Objects;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
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

      try {
        Player player = event.getPlayer();
        plugin.getLogger().info("●getGameMode:" + event.getPlayer().getGameMode());
        plugin.getLogger().info("●isSneaking:" + event.getPlayer().isSneaking());
        plugin.getLogger().info("●getHand:" + event.getHand());

        ItemStack item = new ItemStack(Material.ACACIA_SIGN);
        ItemMeta meta = item.getItemMeta();
        Objects.requireNonNull(meta).setDisplayName("TestSign");
        item.setItemMeta(meta);
        player.getInventory().setItemInMainHand(item);
        plugin.getLogger().info("●items:" + item);
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

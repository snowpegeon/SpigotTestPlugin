package com.github.saidred.spigotTestPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotTestPlugin extends JavaPlugin {
  public static JavaPlugin plugin;
  public SpigotTestPlugin(){plugin = this;}

  @Override
  public void onEnable() {
    // イベントサンプル
    getServer().getPluginManager().registerEvents(new testEvent(),this);
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

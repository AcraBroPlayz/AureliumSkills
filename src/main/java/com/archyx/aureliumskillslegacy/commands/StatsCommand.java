package com.archyx.aureliumskillslegacy.commands;

import com.archyx.aureliumskillslegacy.menu.StatsMenu;
import org.bukkit.entity.Player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;

@CommandAlias("stats")
public class StatsCommand extends BaseCommand {

	@Default
	public void onStats(Player player) {
		StatsMenu.getInventory(player).open(player);
	}
	
}

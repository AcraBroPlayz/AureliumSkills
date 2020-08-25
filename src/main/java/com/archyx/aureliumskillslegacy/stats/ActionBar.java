package com.archyx.aureliumskillslegacy.stats;

import com.archyx.aureliumskillslegacy.Options;
import com.archyx.aureliumskillslegacy.Setting;
import com.archyx.aureliumskillslegacy.lang.Lang;
import com.archyx.aureliumskillslegacy.lang.Message;
import com.archyx.aureliumskillslegacy.magic.ManaManager;
import com.archyx.aureliumskillslegacy.AureliumSkills;
import com.archyx.aureliumskillslegacy.util.ActionBarUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.UUID;

public class ActionBar {

	private final Plugin plugin;
	private ManaManager mana;

	public ActionBar(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public static HashMap<UUID, Boolean> isGainingXp = new HashMap<>();
	public static HashMap<UUID, Integer> timer = new HashMap<>();
	public static HashMap<UUID, Integer> currentAction = new HashMap<>();

	public void startUpdateActionBar() {
		mana = AureliumSkills.manaManager;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
			if (Options.enable_action_bar) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (!currentAction.containsKey(player.getUniqueId())) {
						currentAction.put(player.getUniqueId(), 0);
					}
					if (isGainingXp.containsKey(player.getUniqueId())) {
						if (!isGainingXp.get(player.getUniqueId())) {
							if (Options.enable_health_on_action_bar && Options.enable_mana_on_action_bar) {
								sendMessage(player, Options.health_text_color + "" + (int) (player.getHealth() * Options.getDoubleOption(Setting.HP_INDICATOR_SCALING)) + "/" + (int) (player.getMaxHealth() * Options.getDoubleOption(Setting.HP_INDICATOR_SCALING)) + " " + Lang.getMessage(Message.HP) +
											"                " + Options.mana_text_color + mana.getMana(player.getUniqueId()) + "/" + mana.getMaxMana(player.getUniqueId()) + " " + Lang.getMessage(Message.MANA));
							}
							else if (Options.enable_health_on_action_bar) {
								sendMessage(player, Options.health_text_color + "" + (int) (player.getHealth() * Options.getDoubleOption(Setting.HP_INDICATOR_SCALING)) + "/" + (int) (player.getMaxHealth() * Options.getDoubleOption(Setting.HP_INDICATOR_SCALING)) + " " + Lang.getMessage(Message.HP));
							}
							else if (Options.enable_mana_on_action_bar) {
								sendMessage(player, Options.mana_text_color + "" + mana.getMana(player.getUniqueId()) + "/" + mana.getMaxMana(player.getUniqueId()) + " " + Lang.getMessage(Message.MANA));
							}
						}
					}
					else {
						isGainingXp.put(player.getUniqueId(), false);
					}
				}
			}
		}, 0L, Options.actionBarUpdatePeriod);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
			if (Options.enable_action_bar) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (timer.containsKey(player.getUniqueId())) {
						if (timer.get(player.getUniqueId()) != 0) {
							timer.put(player.getUniqueId(), timer.get(player.getUniqueId()) - 1);
						}
					} else {
						timer.put(player.getUniqueId(), 0);
					}
				}
			}
		}, 0L, 2L);
	}

	public static void sendMessage(Player p, String message) {
		ActionBarUtil.sendActionBar(p, message);
	}

}

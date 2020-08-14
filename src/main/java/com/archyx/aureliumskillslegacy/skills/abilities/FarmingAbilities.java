package com.archyx.aureliumskillslegacy.skills.abilities;

import com.archyx.aureliumskillslegacy.Options;
import com.archyx.aureliumskillslegacy.skills.Skill;
import com.archyx.aureliumskillslegacy.skills.PlayerSkill;
import com.archyx.aureliumskillslegacy.skills.SkillLoader;
import com.archyx.aureliumskillslegacy.skills.Source;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class FarmingAbilities implements Listener {

	private static final Random r = new Random();
	
	public static double getModifiedXp(Player player, Source source) {
		PlayerSkill skill = SkillLoader.playerSkills.get(player.getUniqueId());
		double output = Options.getXpAmount(source);
		double modifier = 1;
		modifier += Ability.FARMER.getValue(skill.getAbilityLevel(Ability.FARMER)) / 100;
		output *= modifier;
		return output;
	}
	
	public static void bountifulHarvest(Player player, Block block) {
		if (Options.isEnabled(Skill.FARMING)) {
			if (player.getGameMode().equals(GameMode.SURVIVAL)) {
				PlayerSkill skill = SkillLoader.playerSkills.get(player.getUniqueId());
				if (skill.getAbilityLevel(Ability.BOUNTIFUL_HARVEST) > 0) {
					if (r.nextDouble() < (Ability.BOUNTIFUL_HARVEST.getValue(skill.getAbilityLevel(Ability.BOUNTIFUL_HARVEST))) / 100) {
						for (ItemStack item : block.getDrops()) {
							player.getWorld().dropItemNaturally(block.getLocation(), item);
						}
					}
				}
			}
		}
	}
	
	public static void tripleHarvest(Player player, Block block) {
		if (Options.isEnabled(Skill.FARMING)) {
			if (player.getGameMode().equals(GameMode.SURVIVAL)) {
				PlayerSkill skill = SkillLoader.playerSkills.get(player.getUniqueId());
				if (skill.getAbilityLevel(Ability.TRIPLE_HARVEST) > 0) {
					if (r.nextDouble() < (Ability.TRIPLE_HARVEST.getValue(skill.getAbilityLevel(Ability.TRIPLE_HARVEST))) / 100) {
						for (ItemStack item : block.getDrops()) {
							player.getWorld().dropItemNaturally(block.getLocation(), item);
							player.getWorld().dropItemNaturally(block.getLocation(), item);
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void geneticist(PlayerItemConsumeEvent event) {
		if (Options.isEnabled(Skill.FARMING)) {
			Player player = (Player) event.getPlayer();
			Material mat = event.getItem().getType();
			if (mat.equals(Material.BREAD) || mat.equals(Material.APPLE) || mat.equals(Material.GOLDEN_APPLE) || mat.equals(Material.POTATO_ITEM)
					|| mat.equals(Material.BAKED_POTATO) || mat.equals(Material.CARROT_ITEM) || mat.equals(Material.GOLDEN_CARROT) || mat.equals(Material.MELON)
					|| mat.equals(Material.PUMPKIN_PIE) || mat.equals(Material.MUSHROOM_SOUP)
					|| mat.equals(Material.POISONOUS_POTATO)) {
				float amount = (float) Ability.GENETICIST.getValue(SkillLoader.playerSkills.get(player.getUniqueId()).getAbilityLevel(Ability.GENETICIST)) / 10;
				player.setSaturation(player.getSaturation() + amount);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void scytheMaster(EntityDamageByEntityEvent event) {
		if (Options.isEnabled(Skill.FARMING)) {
			if (!event.isCancelled()) {
				if (event.getDamager() instanceof Player) {
					Player player = (Player) event.getDamager();
					if (SkillLoader.playerSkills.containsKey(player.getUniqueId())) {
						if (event.getCause().equals(DamageCause.ENTITY_ATTACK)) {
							Material mat = player.getInventory().getItemInHand().getType();
							if (mat.equals(Material.DIAMOND_HOE) || mat.equals(Material.IRON_HOE) || mat.equals(Material.GOLD_HOE)
									|| mat.equals(Material.STONE_HOE) || mat.equals(Material.WOOD_HOE)) {
								PlayerSkill s = SkillLoader.playerSkills.get(player.getUniqueId());
								event.setDamage(event.getDamage() * (1 + (Ability.SCYTHE_MASTER.getValue(s.getAbilityLevel(Ability.SCYTHE_MASTER)) / 100)));
							}
						}
					}
				}
			}
		}
	}
	
}

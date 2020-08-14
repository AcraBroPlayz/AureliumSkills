package com.archyx.aureliumskillslegacy.skills.levelers;

import com.archyx.aureliumskillslegacy.Options;
import com.archyx.aureliumskillslegacy.skills.Skill;
import com.archyx.aureliumskillslegacy.AureliumSkills;
import com.archyx.aureliumskillslegacy.skills.Source;
import com.archyx.aureliumskillslegacy.skills.abilities.FarmingAbilities;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.NetherWartsState;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.material.Crops;
import org.bukkit.material.NetherWarts;

public class FarmingLeveler implements Listener{

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBreak(BlockBreakEvent event) {
		if (Options.isEnabled(Skill.FARMING)) {
			if (!event.isCancelled()) {
				//Checks if in blocked world
				if (AureliumSkills.worldManager.isInBlockedWorld(event.getBlock().getLocation())) {
					return;
				}
				//Checks if in blocked region
				if (AureliumSkills.worldGuardEnabled) {
					if (AureliumSkills.worldGuardSupport.isInBlockedRegion(event.getBlock().getLocation())) {
						return;
					}
				}
				Player p = event.getPlayer();
				Block b = event.getBlock();
				Skill s = Skill.FARMING;
				Material mat = b.getType();
				if (mat.equals(Material.CARROT)) {
					Crops crops = (Crops) b.getState().getData();
					if (crops.getState().equals(CropState.RIPE)) {
						Leveler.addXp(p, s, FarmingAbilities.getModifiedXp(p, Source.CARROT));
						applyAbilities(p, b);
					}
				} else if (mat.equals(Material.POTATO)) {
					Crops crops = (Crops) b.getState().getData();
					if (crops.getState().equals(CropState.RIPE)) {
						Leveler.addXp(p, s, FarmingAbilities.getModifiedXp(p, Source.POTATO));
						applyAbilities(p, b);
					}
				} else if (mat.equals(Material.NETHER_STALK)) {
					NetherWarts crops = (NetherWarts) b.getState().getData();
					if (crops.getState().equals(NetherWartsState.RIPE)) {
						Leveler.addXp(p, s, FarmingAbilities.getModifiedXp(p, Source.NETHER_WART));
						applyAbilities(p, b);
					}
				}
				else if (mat.equals(Material.CROPS)) {
					Crops crops = (Crops) b.getState().getData();
					if (crops.getState().equals(CropState.RIPE)) {
						Leveler.addXp(p, s, FarmingAbilities.getModifiedXp(p, Source.WHEAT));
						applyAbilities(p, b);
					}
				}
				else if (mat.equals(Material.PUMPKIN)) {
					if (Options.checkBlockReplace) {
						if (b.hasMetadata("skillsPlaced")) {
							return;
						}
					}
					Leveler.addXp(p, s, FarmingAbilities.getModifiedXp(p, Source.PUMPKIN));
					applyAbilities(p, b);

				}
				else if (mat.equals(XMaterial.MELON.parseMaterial())) {
					if (Options.checkBlockReplace) {
						if (b.hasMetadata("skillsPlaced")) {
							return;
						}
					}
					Leveler.addXp(p, s, FarmingAbilities.getModifiedXp(p, Source.MELON));
					applyAbilities(p, b);
				}
				else if (isSugarCane(mat)) {
					int numBroken = 1;
					if (Options.checkBlockReplace) {
						if (b.hasMetadata("skillsPlaced")) {
							if (!isSugarCane(b.getRelative(BlockFace.UP).getType()) || b.getRelative(BlockFace.UP).hasMetadata("skillsPlaced")) {
								return;
							}
							numBroken = 0;
						}
					}
					if (isSugarCane(b.getRelative(BlockFace.UP).getState().getType())) {
						numBroken++;
						if (isSugarCane(b.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getState().getType())) {
							numBroken++;
						}
					}
					Leveler.addXp(p, s, FarmingAbilities.getModifiedXp(p, Source.SUGAR_CANE) * numBroken);
					applyAbilities(p, b);
				}
			}
		}
	}
	
	private void applyAbilities(Player player, Block block) {
		FarmingAbilities.bountifulHarvest(player, block);
		FarmingAbilities.tripleHarvest(player, block);
	}

	public static boolean isSugarCane(Material material) {
		if (XMaterial.isNewVersion()) {
			return material.equals(Material.SUGAR_CANE);
		}
		else {
			return material.equals(Material.valueOf("SUGAR_CANE_BLOCK"));
		}
	}
}

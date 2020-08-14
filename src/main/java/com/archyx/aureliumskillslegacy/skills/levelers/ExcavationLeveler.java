package com.archyx.aureliumskillslegacy.skills.levelers;

import com.archyx.aureliumskillslegacy.Options;
import com.archyx.aureliumskillslegacy.skills.Skill;
import com.archyx.aureliumskillslegacy.skills.abilities.ExcavationAbilities;
import com.archyx.aureliumskillslegacy.AureliumSkills;
import com.archyx.aureliumskillslegacy.skills.Source;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ExcavationLeveler implements Listener{

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBreak(BlockBreakEvent event) {
		if (Options.isEnabled(Skill.EXCAVATION)) {
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
				//Check block replace
				if (Options.checkBlockReplace) {
					if (event.getBlock().hasMetadata("skillsPlaced")) {
						return;
					}
				}
				Skill s = Skill.EXCAVATION;
				Player p = event.getPlayer();
				Material mat = event.getBlock().getType();
				if (mat.equals(Material.DIRT)) {
					Leveler.addXp(p, s, ExcavationAbilities.getModifiedXp(p, Source.DIRT));
				}
				else if (mat.equals(Material.SAND)) {
					Leveler.addXp(p, s, ExcavationAbilities.getModifiedXp(p, Source.SAND));
				}
				else if (mat.equals(Material.GRASS)) {
					Leveler.addXp(p, s, ExcavationAbilities.getModifiedXp(p, Source.GRASS_BLOCK));
				}
				else if (mat.equals(Material.GRAVEL)) {
					Leveler.addXp(p, s, ExcavationAbilities.getModifiedXp(p, Source.GRAVEL));
				}
				else if (mat.equals(Material.CLAY)) {
					Leveler.addXp(p, s, ExcavationAbilities.getModifiedXp(p, Source.CLAY));
				}
				else if (mat.equals(Material.SOUL_SAND)) {
					Leveler.addXp(p, s, ExcavationAbilities.getModifiedXp(p, Source.SOUL_SAND));
				}
				else if (mat.equals(Material.MYCEL)) {
					Leveler.addXp(p, s, ExcavationAbilities.getModifiedXp(p, Source.MYCELIUM));
				}
			}
		}
	}
}

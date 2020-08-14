package com.archyx.aureliumskillslegacy.skills.abilities.mana_abilities;

import com.archyx.aureliumskillslegacy.lang.Lang;
import com.archyx.aureliumskillslegacy.AureliumSkills;
import com.archyx.aureliumskillslegacy.lang.Message;
import com.archyx.aureliumskillslegacy.skills.PlayerSkill;
import com.archyx.aureliumskillslegacy.skills.SkillLoader;
import com.archyx.aureliumskillslegacy.skills.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedMine implements ManaAbility {

    @Override
    public void activate(Player player) {
        if (SkillLoader.playerSkills.containsKey(player.getUniqueId())) {
            PlayerSkill skill = SkillLoader.playerSkills.get(player.getUniqueId());
            //Apply haste
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, (int) (Ability.SPEED_MINE.getValue(skill.getAbilityLevel(Ability.SPEED_MINE)) * 20), 9, false, false), true);
            //Play sound
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
            //Consume mana
            int manaConsumed = MAbility.TREECAPITATOR.getManaCost(skill.getAbilityLevel(Ability.SPEED_MINE));
            AureliumSkills.manaManager.setMana(player.getUniqueId(), AureliumSkills.manaManager.getMana(player.getUniqueId()) - manaConsumed);
            player.sendMessage(AureliumSkills.tag + ChatColor.GOLD + Lang.getMessage(Message.SPEED_MINE_ACTIVATED) + " " + ChatColor.GRAY + "(-" + manaConsumed + " " + Lang.getMessage(Message.MANA) + ")");
        }
    }

    @Override
    public void update(Player player) {

    }

    @Override
    public void stop(Player player) {
        if (SkillLoader.playerSkills.containsKey(player.getUniqueId())) {
            PlayerSkill skill = SkillLoader.playerSkills.get(player.getUniqueId());
            AureliumSkills.manaAbilityManager.setCooldown(player.getUniqueId(), MAbility.SPEED_MINE, MAbility.SPEED_MINE.getCooldown(skill.getAbilityLevel(Ability.SPEED_MINE)));
            player.sendMessage(AureliumSkills.tag + ChatColor.GOLD + Lang.getMessage(Message.SPEED_MINE_WORN_OFF));
        }
    }
}

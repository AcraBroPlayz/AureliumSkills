package com.archyx.aureliumskills.configuration;


public enum Option {

    DATA_SAVE_PERIOD("data-save-period", OptionType.INT),
    // Mysql Options
    MYSQL_ENABLED("mysql.enabled", OptionType.BOOLEAN),
    MYSQL_HOST("mysql.host", OptionType.STRING),
    MYSQL_PORT("mysql.port", OptionType.INT),
    MYSQL_DATABASE("mysql.database", OptionType.STRING),
    MYSQL_USERNAME("mysql.username", OptionType.STRING),
    MYSQL_PASSWORD("mysql.password", OptionType.STRING),
    TRY_DETECT_CLIENT_LANGUAGE("try-detect-client-language", OptionType.BOOLEAN),
    // Action bar options
    ACTION_BAR_ENABLED("action-bar.enabled", OptionType.BOOLEAN),
    ACTION_BAR_IDLE("action-bar.idle", OptionType.BOOLEAN),
    ACTION_BAR_XP("action-bar.xp", OptionType.BOOLEAN),
    ACTION_BAR_MAXED("action-bar.maxed", OptionType.BOOLEAN),
    ACTION_BAR_UPDATE_PERIOD("action-bar.update-period", OptionType.INT),
    ACTION_BAR_ROUND_XP("action-bar.round-xp", OptionType.BOOLEAN),
    ACTION_BAR_PLACEHOLDER_API("action-bar.placeholder-api", OptionType.BOOLEAN),
    // Boss bar options
    BOSS_BAR_ENABLED("boss-bar.enabled", OptionType.BOOLEAN),
    BOSS_BAR_MODE("boss-bar.mode", OptionType.STRING),
    BOSS_BAR_STAY_TIME("boss-bar.stay-time", OptionType.INT),
    BOSS_BAR_UPDATE_EVERY("boss-bar.update-every", OptionType.INT),
    BOSS_BAR_ROUND_XP("boss-bar.round-xp", OptionType.BOOLEAN),
    BOSS_BAR_FORMAT("boss-bar.format", OptionType.LIST),
    // Prefix options
    BASE_MANA("base-mana", OptionType.INT),
    ENABLE_ROMAN_NUMERALS("enable-roman-numerals", OptionType.BOOLEAN),
    // Damage hologram options
    DAMAGE_HOLOGRAMS("damage-holograms", OptionType.BOOLEAN),
    DAMAGE_HOLOGRAMS_SCALING("damage-holograms-scaling", OptionType.BOOLEAN),
    DAMAGE_HOLOGRAMS_DECIMAL_MAX("damage-holograms-decimal.decimal-max-amount", OptionType.INT),
    DAMAGE_HOLOGRAMS_DECIMAL_LESS_THAN("damage-holograms-decimal.display-when-less-than", OptionType.INT),
    DAMAGE_HOLOGRAMS_OFFSET_X("damage-holograms-offset.x", OptionType.DOUBLE),
    DAMAGE_HOLOGRAMS_OFFSET_Y("damage-holograms-offset.y", OptionType.DOUBLE),
    DAMAGE_HOLOGRAMS_OFFSET_Z("damage-holograms-offset.z", OptionType.DOUBLE),
    DAMAGE_HOLOGRAMS_OFFSET_RANDOM_ENABLED("damage-holograms-offset.random.enabled", OptionType.BOOLEAN),
    DAMAGE_HOLOGRAMS_OFFSET_RANDOM_X_MIN("damage-holograms-offset.random.x-min", OptionType.DOUBLE),
    DAMAGE_HOLOGRAMS_OFFSET_RANDOM_X_MAX("damage-holograms-offset.random.x-max", OptionType.DOUBLE),
    DAMAGE_HOLOGRAMS_OFFSET_RANDOM_Y_MIN("damage-holograms-offset.random.y-min", OptionType.DOUBLE),
    DAMAGE_HOLOGRAMS_OFFSET_RANDOM_Y_MAX("damage-holograms-offset.random.y-max", OptionType.DOUBLE),
    DAMAGE_HOLOGRAMS_OFFSET_RANDOM_Z_MIN("damage-holograms-offset.random.z-min", OptionType.DOUBLE),
    DAMAGE_HOLOGRAMS_OFFSET_RANDOM_Z_MAX("damage-holograms-offset.random.z-max", OptionType.DOUBLE),
    LEADERBOARDS_UPDATE_PERIOD("leaderboards.update-period", OptionType.INT),
    LEADERBOARDS_UPDATE_DELAY("leaderboards.update-delay", OptionType.INT),
    SKILL_LEVEL_REQUIREMENTS_MULTIPLIER("skill-level-requirements-multiplier", OptionType.DOUBLE),
    ENABLE_SKILL_COMMANDS("enable-skill-commands", OptionType.BOOLEAN),
    CHECK_BLOCK_REPLACE("check-block-replace", OptionType.BOOLEAN),
    DISABLE_IN_CREATIVE_MODE("disable-in-creative-mode", OptionType.BOOLEAN),
    SKILL_MONEY_REWARDS_ENABLED("skill-money-rewards.enabled", OptionType.BOOLEAN),
    SKILL_MONEY_REWARDS_BASE("skill-money-rewards.base", OptionType.DOUBLE),
    SKILL_MONEY_REWARDS_MULTIPLIER("skill-money-rewards.multiplier", OptionType.DOUBLE),
    // Leveler options
    LEVELER_TITLE_ENABLED("leveler.title.enabled", OptionType.BOOLEAN),
    LEVELER_TITLE_FADE_IN("leveler.title.fade-in", OptionType.INT),
    LEVELER_TITLE_STAY("leveler.title.stay", OptionType.INT),
    LEVELER_TITLE_FADE_OUT("leveler.title.fade-out", OptionType.INT),
    LEVELER_SOUND_ENABLED("leveler.sound.enabled", OptionType.BOOLEAN),
    LEVELER_SOUND_TYPE("leveler.sound.type", OptionType.STRING),
    LEVELER_SOUND_CATEGORY("leveler.sound.category", OptionType.STRING),
    LEVELER_SOUND_VOLUME("leveler.sound.volume", OptionType.DOUBLE),
    LEVELER_SOUND_PITCH("leveler.sound.pitch", OptionType.DOUBLE),
    LEVELER_DOUBLE_CHECK_DELAY("leveler.double-check-delay", OptionType.INT),
    // Modifier options
    MODIFIER_ARMOR_EQUIP_BLOCKED_MATERIALS("modifier.armor.equip-blocked-materials", OptionType.LIST),
    MODIFIER_ITEM_CHECK_PERIOD("modifier.item.check-period", OptionType.INT),
    MODIFIER_ITEM_ENABLE_OFF_HAND("modifier.item.enable-off-hand", OptionType.BOOLEAN),
    // Requirement options
    REQUIREMENT_ITEM_PREVENT_TOOL_USE("requirement.item.prevent-tool-use", OptionType.BOOLEAN),
    REQUIREMENT_ITEM_PREVENT_WEAPON_USE("requirement.item.prevent-weapon-use", OptionType.BOOLEAN),
    REQUIREMENT_ITEM_PREVENT_BLOCK_PLACE("requirement.item.prevent-block-place", OptionType.BOOLEAN),
    REQUIREMENT_ARMOR_PREVENT_ARMOR_EQUIP("requirement.armor.prevent-armor-equip", OptionType.BOOLEAN),
    // Critical options
    CRITICAL_BASE_MULTIPLIER("critical.base-multiplier", OptionType.DOUBLE),
    CRITICAL_ENABLED_SWORD("critical.enabled.sword", OptionType.BOOLEAN),
    CRITICAL_ENABLED_BOW("critical.enabled.bow", OptionType.BOOLEAN),
    CRITICAL_ENABLED_AXE("critical.enabled.axe", OptionType.BOOLEAN),
    CRITICAL_ENABLED_PICKAXE("critical.enabled.pickaxe", OptionType.BOOLEAN),
    CRITICAL_ENABLED_SHOVEL("critical.enabled.shovel", OptionType.BOOLEAN),
    CRITICAL_ENABLED_HOE("critical.enabled.hoe", OptionType.BOOLEAN),
    CRITICAL_ENABLED_HAND("critical.enabled.hand", OptionType.BOOLEAN),
    CRITICAL_ENABLED_OTHER("critical.enabled.other", OptionType.BOOLEAN),
    //Skill options (not including source types)
    FARMING_ENABLED("farming.enabled", OptionType.BOOLEAN),
    FARMING_MAX_LEVEL("farming.max-level", OptionType.INT),
    FARMING_CHECK_CANCELLED("farming.check-cancelled", OptionType.BOOLEAN),
    FORAGING_ENABLED("foraging.enabled", OptionType.BOOLEAN),
    FORAGING_MAX_LEVEL("foraging.max-level", OptionType.INT),
    FORAGING_CHECK_CANCELLED("foraging.check-cancelled", OptionType.BOOLEAN),
    MINING_ENABLED("mining.enabled", OptionType.BOOLEAN),
    MINING_MAX_LEVEL("mining.max-level", OptionType.INT),
    MINING_CHECK_CANCELLED("mining.check-cancelled", OptionType.BOOLEAN),
    FISHING_ENABLED("fishing.enabled", OptionType.BOOLEAN),
    FISHING_MAX_LEVEL("fishing.max-level", OptionType.INT),
    FISHING_CHECK_CANCELLED("fishing.check-cancelled", OptionType.BOOLEAN),
    EXCAVATION_ENABLED("excavation.enabled", OptionType.BOOLEAN),
    EXCAVATION_MAX_LEVEL("excavation.max-level", OptionType.INT),
    EXCAVATION_CHECK_CANCELLED("excavation.check-cancelled", OptionType.BOOLEAN),
    ARCHERY_ENABLED("archery.enabled", OptionType.BOOLEAN),
    ARCHERY_MAX_LEVEL("archery.max-level", OptionType.INT),
    DEFENSE_ENABLED("defense.enabled", OptionType.BOOLEAN),
    DEFENSE_MAX_LEVEL("defense.max-level", OptionType.INT),
    DEFENSE_CHECK_CANCELLED("defense.check-cancelled", OptionType.BOOLEAN),
    DEFENSE_MAX("defense.max", OptionType.DOUBLE),
    DEFENSE_MIN("defense.min", OptionType.DOUBLE),
    FIGHTING_ENABLED("fighting.enabled", OptionType.BOOLEAN),
    FIGHTING_MAX_LEVEL("fighting.max-level", OptionType.INT),
    ENDURANCE_ENABLED("endurance.enabled", OptionType.BOOLEAN),
    ENDURANCE_MAX_LEVEL("endurance.max-level", OptionType.INT),
    ENDURANCE_XP_GAIN_PERIOD("endurance.xp-gain-period", OptionType.INT),
    AGILITY_ENABLED("agility.enabled", OptionType.BOOLEAN),
    AGILITY_MAX_LEVEL("agility.max-level", OptionType.INT),
    AGILITY_CHECK_CANCELLED("agility.check-cancelled", OptionType.BOOLEAN),
    ALCHEMY_ENABLED("alchemy.enabled", OptionType.BOOLEAN),
    ALCHEMY_MAX_LEVEL("alchemy.max-level", OptionType.INT),
    ALCHEMY_CHECK_CANCELLED("alchemy.check-cancelled", OptionType.BOOLEAN),
    ENCHANTING_ENABLED("enchanting.enabled", OptionType.BOOLEAN),
    ENCHANTING_MAX_LEVEL("enchanting.max-level", OptionType.INT),
    ENCHANTING_CHECK_CANCELLED("enchanting.check-cancelled", OptionType.BOOLEAN),
    SORCERY_ENABLED("sorcery.enabled", OptionType.BOOLEAN),
    SORCERY_MAX_LEVEL("sorcery.max-level", OptionType.INT),
    HEALING_ENABLED("healing.enabled", OptionType.BOOLEAN),
    HEALING_MAX_LEVEL("healing.max-level", OptionType.INT),
    HEALING_CHECK_CANCELLED("healing.check-cancelled", OptionType.BOOLEAN),
    FORGING_ENABLED("forging.enabled", OptionType.BOOLEAN),
    FORGING_MAX_LEVEL("forging.max-level", OptionType.INT),
    FORGING_CHECK_CANCELLED("forging.check-cancelled", OptionType.BOOLEAN),
    // Stat options
    HEALTH_MODIFIER("health.modifier", OptionType.DOUBLE),
    HEALTH_HEALTH_SCALING("health.health-scaling", OptionType.BOOLEAN),
    HEALTH_HP_INDICATOR_SCALING("health.hp-indicator-scaling", OptionType.DOUBLE),
    HEALTH_UPDATE_DELAY("health.update-delay", OptionType.INT),
    HEALTH_FORCE_BASE_HEALTH("health.force-base-health", OptionType.BOOLEAN),
    STRENGTH_MODIFIER("strength.modifier", OptionType.DOUBLE),
    STRENGTH_HAND_DAMAGE("strength.hand-damage", OptionType.BOOLEAN),
    STRENGTH_BOW_DAMAGE("strength.bow-damage", OptionType.BOOLEAN),
    STRENGTH_DISPLAY_DAMAGE_WITH_HEALTH_SCALING("strength.display-damage-with-health-scaling", OptionType.BOOLEAN),
    TOUGHNESS_NEW_MODIFIER("toughness.new-modifier", OptionType.DOUBLE),
    REGENERATION_CUSTOM_REGEN_MECHANICS("regeneration.custom-regen-mechanics", OptionType.BOOLEAN),
    REGENERATION_BASE_REGEN("regeneration.base-regen", OptionType.DOUBLE),
    REGENERATION_SATURATED_MODIFIER("regeneration.saturated-modifier", OptionType.DOUBLE),
    REGENERATION_HUNGER_FULL_MODIFIER("regeneration.hunger-full-modifier", OptionType.DOUBLE),
    REGENERATION_HUNGER_ALMOST_FULL_MODIFIER("regeneration.hunger-almost-full-modifier", OptionType.DOUBLE),
    REGENERATION_SATURATED_DELAY("regeneration.custom-regen-options.saturated-delay", OptionType.INT),
    REGENERATION_HUNGER_DELAY("regeneration.custom-regen-options.hunger-delay", OptionType.INT),
    REGENERATION_MANA_MODIFIER("regeneration.mana-modifier", OptionType.DOUBLE),
    REGENERATION_BASE_MANA_REGEN("regeneration.base-mana-regen", OptionType.INT),
    LUCK_MODIFIER("luck.modifier", OptionType.DOUBLE),
    LUCK_DOUBLE_DROP_ENABLED("luck.double-drop-enabled", OptionType.BOOLEAN),
    LUCK_DOUBLE_DROP_MODIFIER("luck.double-drop-modifier", OptionType.DOUBLE),
    LUCK_DOUBLE_DROP_PERCENT_MAX("luck.double-drop-percent-max", OptionType.DOUBLE),
    WISDOM_ANVIL_COST_MODIFIER("wisdom.anvil-cost-modifier", OptionType.DOUBLE),
    WISDOM_EXPERIENCE_MODIFIER("wisdom.experience-modifier", OptionType.DOUBLE),
    WISDOM_ALLOW_OVER_MAX_MANA("wisdom.allow-over-max-mana", OptionType.BOOLEAN);

    private final String path;
    private final OptionType type;

    Option(String path, OptionType type) {
        this.path = path;
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public OptionType getType() {
        return type;
    }

}
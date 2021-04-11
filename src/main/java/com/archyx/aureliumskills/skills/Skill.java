package com.archyx.aureliumskills.skills;

import com.archyx.aureliumskills.abilities.Ability;
import com.archyx.aureliumskills.mana.MAbility;
import com.archyx.aureliumskills.stats.Stat;
import com.google.common.collect.ImmutableList;

import javax.annotation.Nullable;
import java.util.Locale;
import java.util.function.Supplier;

public interface Skill {

    ImmutableList<Supplier<Ability>> getAbilities();

    String getDescription(Locale locale);

    String getDisplayName(Locale locale);

    Stat getPrimaryStat();

    Stat getSecondaryStat();

    @Nullable
    MAbility getManaAbility();

    String name();

    String toString();

}

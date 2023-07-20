package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.common.StarMap;

/*
  天喜
 */
/**
 * Represents the Sky Happiness star in the Star Map.
 */
public class SkyHappiness implements StarMap {

    // Defining constant for the star's name
    private static final String SKY_HAPPINESS = "天喜";
    // A map that associates each stem with a branch that makes up a Sky Happiness combination
    private static final ImmutableMap<String, String> MAP;

    static {
        MAP = ImmutableMap.<String, String>builder()
                .put("子", "酉")
                .put("丑", "申")
                .put("寅", "未")
                .put("卯", "午")
                .put("辰", "巳")
                .put("巳", "辰")
                .put("午", "卯")
                .put("未", "寅")
                .put("申", "丑")
                .put("酉", "子")
                .put("戌", "亥")
                .put("亥", "戌")
                .build();
    }

    /**
     * Returns the map that associates each stem with a branch that makes up a Sky Happiness combination.
     */
    public static ImmutableMap<String, String> getMap() {
        return MAP;
    }

    /**
     * Returns the name of the star, which is "天喜".
     */
    @Override
    public String getName() {
        return SKY_HAPPINESS;
    }
}


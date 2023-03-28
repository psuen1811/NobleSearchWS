package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.common.Star;
import com.pakfortune.common.StarMap;

/**
 * Represents the Money star in the Star Map.
 */
public class Money implements Star, StarMap {

    // Defining constant for the star's name
    private static final String MONEY = "祿存";
    // A map that associates each stem with a branch that makes up a Money combination
    private static final ImmutableMap<String, String> MAP;

    static {
        MAP = ImmutableMap.<String, String>builder()
                .put("甲", "丙寅")
                .put("乙", "己卯")
                .put("丙", "癸巳")
                .put("丁", "丙午")
                .put("戊", "丁巳")
                .put("己", "庚午")
                .put("庚", "甲申")
                .put("辛", "丁酉")
                .put("壬", "辛亥")
                .put("癸", "甲子")
                .build();
    }

    /**
     * Returns the map that associates each stem with a branch that makes up a Money combination.
     */
    public ImmutableMap<String, String> getMap() {
        return MAP;
    }

    /**
     * Returns the name of the star, which is "祿存".
     */
    @Override
    public String getName() {
        return MONEY;
    }
}


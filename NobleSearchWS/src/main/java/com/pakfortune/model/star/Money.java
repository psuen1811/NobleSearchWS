package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.common.Star;
import com.pakfortune.common.StarMap;

public class Money extends StarMap implements Star {

    // Constant for the name of this star
    private static final String MONEY = "祿存";

    // Immutable map for storing the corresponding values for each input
    private static final ImmutableMap<String, String> map = ImmutableMap.<String, String>builder()
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

    // Returns the immutable map containing the values for this star
    public static ImmutableMap<String, String> getMap() {
        return map;
    }

    // Returns the name of this star
    @Override
    public String getName() {
        return MONEY;
    }
}

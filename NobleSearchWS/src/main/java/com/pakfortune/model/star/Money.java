package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.common.Star;
import com.pakfortune.common.StarMap;

public class Money extends StarMap implements Star {

    private static final String MONEY = "祿存";
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


    public static ImmutableMap<String, String> getMap() {
        return map;
    }

    public String getName() {
        return MONEY;
    }
}

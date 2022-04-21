package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;

public class Money extends StarMap {

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


    public ImmutableMap<String, String> getMap() {
        return map;
    }

    public String getMONEY() {
        return MONEY;
    }
}

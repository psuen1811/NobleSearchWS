package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;

@SuppressWarnings("ALL")
public class Study extends StarMap {

    private static final String STUDY = "文昌";
    private static final ImmutableMap<String, String> map = ImmutableMap.<String, String>builder()
            .put("甲", "己巳")
            .put("乙", "壬午")
            .put("丙", "丙申")
            .put("丁", "己酉")
            .put("戊", "庚申")
            .put("己", "癸酉")
            .put("庚", "丁亥")
            .put("辛", "庚子")
            .put("壬", "壬寅")
            .put("癸", "乙卯")
            .build();

    public static ImmutableMap<String, String> getMap()  {
        return map;
    }

    public static String getSTUDY() {
        return STUDY;
    }
}

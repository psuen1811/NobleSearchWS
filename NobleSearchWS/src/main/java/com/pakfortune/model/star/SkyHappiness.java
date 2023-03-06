package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.common.Star;
import com.pakfortune.common.StarMap;

/*
  天喜
 */
public class SkyHappiness extends StarMap implements Star {

    private static final String SKY_HAPPINESS = "天喜";
    private static final ImmutableMap<String, String> map = ImmutableMap.<String, String>builder()
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

    public static ImmutableMap<String, String> getMap() {
        return map;
    }

    @Override
    public String getName() {
        return SKY_HAPPINESS;
    }
}

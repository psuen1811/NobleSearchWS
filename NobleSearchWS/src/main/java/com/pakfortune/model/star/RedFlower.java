package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.common.GetInformation;

/*
  紅鸞
 */
public class RedFlower extends GetInformation {

    private static final String RED_FLOWER = "紅鸞";
    private static final ImmutableMap<String, String> map = ImmutableMap.<String, String>builder()
            .put("子", "卯")
            .put("丑", "寅")
            .put("寅", "丑")
            .put("卯", "子")
            .put("辰", "亥")
            .put("巳", "戌")
            .put("午", "酉")
            .put("未", "申")
            .put("申", "未")
            .put("酉", "午")
            .put("戌", "巳")
            .put("亥", "辰")
            .build();

    public static ImmutableMap<String, String> getMap() {
        return map;
    }

    public static String getRedFlower() {
        return RED_FLOWER;
    }
}

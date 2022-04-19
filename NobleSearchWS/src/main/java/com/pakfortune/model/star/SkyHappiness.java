package com.pakfortune.model.star;



import com.pakfortune.common.GetInformation;

import java.util.HashMap;

/*
  天喜
 */
public class SkyHappiness extends GetInformation {

    private static final HashMap<String, String> map = new HashMap<>();
    private static final String SKY_HAPPINESS = "天喜";

    static {
        getMap().put("子", "酉");
        getMap().put("丑", "申");
        getMap().put("寅", "未");
        getMap().put("卯", "午");
        getMap().put("辰", "巳");
        getMap().put("巳", "辰");
        getMap().put("午", "卯");
        getMap().put("未", "寅");
        getMap().put("申", "丑");
        getMap().put("酉", "子");
        getMap().put("戌", "亥");
        getMap().put("亥", "戌");
    }

    public static HashMap<String, String> getMap() {
        return map;
    }

    public static String getSkyHappiness() {
        return SKY_HAPPINESS;
    }
}

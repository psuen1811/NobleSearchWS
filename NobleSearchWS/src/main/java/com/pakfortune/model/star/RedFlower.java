package com.pakfortune.model.star;

import com.pakfortune.common.GetInformation;

import java.util.HashMap;

/*
  紅鸞
 */
public class RedFlower extends GetInformation {

    private static final HashMap<String, String> map = new HashMap<>();
    private static final String RED_FLOWER = "紅鸞";

    static {
        getMap().put("子", "卯");
        getMap().put("丑", "寅");
        getMap().put("寅", "丑");
        getMap().put("卯", "子");
        getMap().put("辰", "亥");
        getMap().put("巳", "戌");
        getMap().put("午", "酉");
        getMap().put("未", "申");
        getMap().put("申", "未");
        getMap().put("酉", "午");
        getMap().put("戌", "巳");
        getMap().put("亥", "辰");
    }

    public static HashMap<String, String> getMap() {
        return map;
    }

    public static String getRedFlower() {
        return RED_FLOWER;
    }
}

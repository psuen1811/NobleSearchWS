package com.pakfortune.model.star;

import com.pakfortune.common.GetInformation;

import java.util.HashMap;

public class Money extends GetInformation {

    private static final HashMap<String, String> map = new HashMap<>();
    private static final String MONEY = "祿存";

    static {
        getMap().put("甲", "丙寅");
        getMap().put("乙", "己卯");
        getMap().put("丙", "癸巳");
        getMap().put("丁", "丙午");
        getMap().put("戊", "丁巳");
        getMap().put("己", "庚午");
        getMap().put("庚", "甲申");
        getMap().put("辛", "丁酉");
        getMap().put("壬", "辛亥");
        getMap().put("癸", "甲子");
    }

    public static HashMap<String, String> getMap() {
        return map;
    }

    public static String getMONEY() {
        return MONEY;
    }
}

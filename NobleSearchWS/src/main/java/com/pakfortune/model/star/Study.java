package com.pakfortune.model.star;

import com.pakfortune.common.GetInformation;

import java.util.HashMap;

@SuppressWarnings("ALL")
public class Study extends GetInformation {

    private static final HashMap<String, String> map = new HashMap<>();
    private static final String STUDY = "文昌";

    static {
        getMap().put("甲", "己巳");
        getMap().put("乙", "壬午");
        getMap().put("丙", "丙申");
        getMap().put("丁", "己酉");
        getMap().put("戊", "庚申");
        getMap().put("己", "癸酉");
        getMap().put("庚", "丁亥");
        getMap().put("辛", "庚子");
        getMap().put("壬", "壬寅");
        getMap().put("癸", "乙卯");
    }

    public static HashMap getMap() {
        return map;
    }

    public static String getSTUDY() {
        return STUDY;
    }
}

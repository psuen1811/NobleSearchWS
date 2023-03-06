package com.pakfortune.common;

import com.pakfortune.model.element.Stem;

// 五虎遁
public abstract class FiveTigerHop extends LookupUtils {
    public static Stem hop(String input) {
        String targetStem = switch (input) {
            case "甲", "己" -> "丙";
            case "乙", "庚" -> "戊";
            case "丙", "辛" -> "庚";
            case "丁", "壬" -> "壬";
            case "戊", "癸" -> "甲";
            default -> throw new IllegalArgumentException("Invalid input value: " + input);
        };

        return getIfPresent(Stem.class, targetStem);
    }
}


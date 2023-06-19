package com.pakfortune.common;

import com.pakfortune.model.element.Stem;

/**
 * This is an abstract class representing the "Five Tiger Escape" (五虎遁) concept in Chinese metaphysics.
 * The method hop() is used to get the "escaped" heavenly stem based on the input stem.
 */
public abstract class FiveTigerHop {

    /**
     * Returns the "escaped" stem according to the input stem based on the rules of "Five Tiger Escape" (五虎遁).
     *
     * @param input The input heavenly stem as a String.
     * @return The "escaped" stem as an object of enum Stem.
     * @throws IllegalArgumentException if the input string is not a valid heavenly stem.
     */
    public static Stem hop(String input) {
        String targetStem = switch (input) {
            case "甲", "己" -> "丙";
            case "乙", "庚" -> "戊";
            case "丙", "辛" -> "庚";
            case "丁", "壬" -> "壬";
            case "戊", "癸" -> "甲";
            default -> throw new IllegalArgumentException("Invalid input value: " + input);
        };

        return LookupUtils.getIfPresent(Stem.class, targetStem);
    }
}



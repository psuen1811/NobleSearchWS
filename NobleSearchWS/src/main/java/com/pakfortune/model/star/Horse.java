package com.pakfortune.model.star;

import com.pakfortune.common.GetResultByStemBranch;
import com.pakfortune.common.Star;
import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;

// Declaring Horse class implementing GetResultByStemBranch and Star interfaces
public class Horse implements GetResultByStemBranch, Star {

    // Defining constants for different directions
    private static final String SOUTH = "寅午戌";
    private static final String NORTH = "申子辰";
    private static final String EAST = "亥卯未";
    private static final String WEST = "巳酉丑";

    // Defining constant for the star's name
    private static final String HORSE = "天馬";

    // Implementing the getName() method from the Star interface
    @Override
    public String getName() {
        return HORSE;
    }

    // Overriding the checkStemBranch() method from the GetResultByStemBranch interface to return the corresponding
    // Jiazi table based on the given stem and branch
    @Override
    public SIXTY_JIAZI_TABLE checkStemBranch(String stem, String branch) {
        SIXTY_JIAZI_TABLE sixtyJiaziTable = null;
        if (SOUTH.contains(branch)) {
            // Using a switch statement to check the stem and assign the corresponding Jiazi table
            sixtyJiaziTable = switch (stem) {
                case "甲" -> SIXTY_JIAZI_TABLE.壬申;
                case "丙" -> SIXTY_JIAZI_TABLE.丙申;
                case "戊" -> SIXTY_JIAZI_TABLE.庚申;
                case "庚" -> SIXTY_JIAZI_TABLE.甲申;
                case "壬" -> SIXTY_JIAZI_TABLE.戊申;
                default -> null;
            };
        } else if (NORTH.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "甲" -> SIXTY_JIAZI_TABLE.丙寅;
                case "丙" -> SIXTY_JIAZI_TABLE.庚寅;
                case "戊" -> SIXTY_JIAZI_TABLE.甲寅;
                case "庚" -> SIXTY_JIAZI_TABLE.戊寅;
                case "壬" -> SIXTY_JIAZI_TABLE.壬寅;
                default -> null;
            };
        } else if (EAST.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "乙" -> SIXTY_JIAZI_TABLE.辛巳;
                case "丁" -> SIXTY_JIAZI_TABLE.乙巳;
                case "己" -> SIXTY_JIAZI_TABLE.己巳;
                case "辛" -> SIXTY_JIAZI_TABLE.癸巳;
                case "癸" -> SIXTY_JIAZI_TABLE.丁巳;
                default -> null;
            };
        } else if (WEST.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "乙" -> SIXTY_JIAZI_TABLE.丁亥;
                case "丁" -> SIXTY_JIAZI_TABLE.辛亥;
                case "己" -> SIXTY_JIAZI_TABLE.乙亥;
                case "辛" -> SIXTY_JIAZI_TABLE.己亥;
                case "癸" -> SIXTY_JIAZI_TABLE.癸亥;
                default -> null;
            };
        }
        return sixtyJiaziTable;
    }
}
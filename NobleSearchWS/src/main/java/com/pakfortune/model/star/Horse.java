package com.pakfortune.model.star;

import com.pakfortune.common.GetResultByStemBranch;
import com.pakfortune.common.Star;
import com.pakfortune.model.element.SixtyJiaziTable;

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
    public String getName() {
        return HORSE;
    }

    // Overriding the checkStemBranch() method from the GetResultByStemBranch interface to return the corresponding
    // Jiazi table based on the given stem and branch
    @Override
    public SixtyJiaziTable checkStemBranch(String stem, String branch) {
        SixtyJiaziTable sixtyJiaziTable = null;
        if (SOUTH.contains(branch)) {
            // Using a switch statement to check the stem and assign the corresponding Jiazi table
            sixtyJiaziTable = switch (stem) {
                case "甲" -> SixtyJiaziTable.壬申;
                case "丙" -> SixtyJiaziTable.丙申;
                case "戊" -> SixtyJiaziTable.庚申;
                case "庚" -> SixtyJiaziTable.甲申;
                case "壬" -> SixtyJiaziTable.戊申;
                default -> null;
            };
        } else if (NORTH.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "甲" -> SixtyJiaziTable.丙寅;
                case "丙" -> SixtyJiaziTable.庚寅;
                case "戊" -> SixtyJiaziTable.甲寅;
                case "庚" -> SixtyJiaziTable.戊寅;
                case "壬" -> SixtyJiaziTable.壬寅;
                default -> null;
            };
        } else if (EAST.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "乙" -> SixtyJiaziTable.辛巳;
                case "丁" -> SixtyJiaziTable.乙巳;
                case "己" -> SixtyJiaziTable.己巳;
                case "辛" -> SixtyJiaziTable.癸巳;
                case "癸" -> SixtyJiaziTable.丁巳;
                default -> null;
            };
        } else if (WEST.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "乙" -> SixtyJiaziTable.丁亥;
                case "丁" -> SixtyJiaziTable.辛亥;
                case "己" -> SixtyJiaziTable.乙亥;
                case "辛" -> SixtyJiaziTable.己亥;
                case "癸" -> SixtyJiaziTable.癸亥;
                default -> null;
            };
        }
        return sixtyJiaziTable;
    }
}
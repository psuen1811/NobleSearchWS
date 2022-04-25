package com.pakfortune.model.star;

import com.pakfortune.common.GetResultByStemBranch;
import com.pakfortune.model.element.SixtyJiaziTable;

public class Horse implements GetResultByStemBranch, Star {

    private static final String SOUTH = "寅午戌";
    private static final String NORTH = "申子辰";
    private static final String EAST = "亥卯未";
    private static final String WEST = "巳酉丑";

    private static final String HORSE = "天馬";

    public String getName() {
        return HORSE;
    }

    @Override
    public SixtyJiaziTable checkStemBranch(String stem, String branch) {
        SixtyJiaziTable sixtyJiaziTable = null;
        if (SOUTH.contains(branch)) {
            switch (stem) {
                case "甲" -> sixtyJiaziTable = SixtyJiaziTable.壬申;
                case "丙" -> sixtyJiaziTable = SixtyJiaziTable.丙申;
                case "戊" -> sixtyJiaziTable = SixtyJiaziTable.庚申;
                case "庚" -> sixtyJiaziTable = SixtyJiaziTable.甲申;
                case "壬" -> sixtyJiaziTable = SixtyJiaziTable.戊申;
            }
        } else if (NORTH.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "甲" -> SixtyJiaziTable.丙寅;
                case "丙" -> SixtyJiaziTable.庚寅;
                case "戊" -> SixtyJiaziTable.甲寅;
                case "庚" -> SixtyJiaziTable.戊寅;
                case "壬" -> SixtyJiaziTable.壬寅;
                default -> sixtyJiaziTable;
            };
        } else if (EAST.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "乙" -> SixtyJiaziTable.辛巳;
                case "丁" -> SixtyJiaziTable.乙巳;
                case "己" -> SixtyJiaziTable.己巳;
                case "辛" -> SixtyJiaziTable.癸巳;
                case "癸" -> SixtyJiaziTable.丁巳;
                default -> sixtyJiaziTable;
            };
        } else if (WEST.contains(branch)) {
            sixtyJiaziTable = switch (stem) {
                case "乙" -> SixtyJiaziTable.丁亥;
                case "丁" -> SixtyJiaziTable.辛亥;
                case "己" -> SixtyJiaziTable.乙亥;
                case "辛" -> SixtyJiaziTable.己亥;
                case "癸" -> SixtyJiaziTable.癸亥;
                default -> sixtyJiaziTable;
            };
        }
        return sixtyJiaziTable;
    }
}

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
                case "甲":
                    sixtyJiaziTable = SixtyJiaziTable.壬申;
                    break;
                case "丙":
                    sixtyJiaziTable = SixtyJiaziTable.丙申;
                    break;
                case "戊":
                    sixtyJiaziTable = SixtyJiaziTable.庚申;
                    break;
                case "庚":
                    sixtyJiaziTable = SixtyJiaziTable.甲申;
                    break;
                case "壬":
                    sixtyJiaziTable = SixtyJiaziTable.戊申;
                    break;
            }
        } else if (NORTH.contains(branch)) {
            switch (stem) {
                case "甲":
                    sixtyJiaziTable = SixtyJiaziTable.丙寅;
                    break;
                case "丙":
                    sixtyJiaziTable = SixtyJiaziTable.庚寅;
                    break;
                case "戊":
                    sixtyJiaziTable = SixtyJiaziTable.甲寅;
                    break;
                case "庚":
                    sixtyJiaziTable = SixtyJiaziTable.戊寅;
                    break;
                case "壬":
                    sixtyJiaziTable = SixtyJiaziTable.壬寅;
                    break;
            }
        } else if (EAST.contains(branch)) {
            switch (stem) {
                case "乙":
                    sixtyJiaziTable = SixtyJiaziTable.辛巳;
                    break;
                case "丁":
                    sixtyJiaziTable = SixtyJiaziTable.乙巳;
                    break;
                case "己":
                    sixtyJiaziTable = SixtyJiaziTable.己巳;
                    break;
                case "辛":
                    sixtyJiaziTable = SixtyJiaziTable.癸巳;
                    break;
                case "癸":
                    sixtyJiaziTable = SixtyJiaziTable.丁巳;
                    break;
            }
        } else if (WEST.contains(branch)) {
            switch (stem) {
                case "乙":
                    sixtyJiaziTable = SixtyJiaziTable.丁亥;
                    break;
                case "丁":
                    sixtyJiaziTable = SixtyJiaziTable.辛亥;
                    break;
                case "己":
                    sixtyJiaziTable = SixtyJiaziTable.乙亥;
                    break;
                case "辛":
                    sixtyJiaziTable = SixtyJiaziTable.己亥;
                    break;
                case "癸":
                    sixtyJiaziTable = SixtyJiaziTable.癸亥;
                    break;
            }
        }
        return sixtyJiaziTable;
    }
}

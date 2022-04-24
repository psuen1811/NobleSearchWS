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
                case "丙":
                    sixtyJiaziTable = SixtyJiaziTable.丙申;
                case "戊":
                    sixtyJiaziTable = SixtyJiaziTable.庚申;
                case "庚":
                    sixtyJiaziTable = SixtyJiaziTable.甲申;
                case "壬":
                    sixtyJiaziTable = SixtyJiaziTable.戊申;
            }
        } else if (NORTH.contains(branch)) {
            switch (stem) {
                case "甲":
                    sixtyJiaziTable = SixtyJiaziTable.丙寅;
                case "丙":
                    sixtyJiaziTable = SixtyJiaziTable.庚寅;
                case "戊":
                    sixtyJiaziTable = SixtyJiaziTable.甲寅;
                case "庚":
                    sixtyJiaziTable = SixtyJiaziTable.戊寅;
                case "壬":
                    sixtyJiaziTable = SixtyJiaziTable.壬寅;
            }
        } else if (EAST.contains(branch)) {
            switch (stem) {
                case "乙":
                    sixtyJiaziTable = SixtyJiaziTable.辛巳;
                case "丁":
                    sixtyJiaziTable = SixtyJiaziTable.乙巳;
                case "己":
                    sixtyJiaziTable = SixtyJiaziTable.己巳;
                case "辛":
                    sixtyJiaziTable = SixtyJiaziTable.癸巳;
                case "癸":
                    sixtyJiaziTable = SixtyJiaziTable.丁巳;
            }
        } else if (WEST.contains(branch)) {
            switch (stem) {
                case "乙":
                    sixtyJiaziTable = SixtyJiaziTable.丁亥;
                case "丁":
                    sixtyJiaziTable = SixtyJiaziTable.辛亥;
                case "己":
                    sixtyJiaziTable = SixtyJiaziTable.乙亥;
                case "辛":
                    sixtyJiaziTable = SixtyJiaziTable.己亥;
                case "癸":
                    sixtyJiaziTable = SixtyJiaziTable.癸亥;
            }
        }
        return sixtyJiaziTable;
    }
}

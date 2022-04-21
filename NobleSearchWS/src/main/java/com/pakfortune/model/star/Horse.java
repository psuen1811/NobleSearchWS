package com.pakfortune.model.star;

import com.pakfortune.common.GetResultByStemBranch;
import com.pakfortune.model.element.SixtyJiaziTable;

public class Horse implements GetResultByStemBranch {

    private static final String SOUTH = "寅午戌";
    private static final String NORTH = "申子辰";
    private static final String EAST = "亥卯未";
    private static final String WEST = "巳酉丑";

    private static final String HORSE = "天馬";

    public static String getHORSE() {
        return HORSE;
    }

    @Override
    public SixtyJiaziTable checkStemBranch(String stem, String branch) {
        SixtyJiaziTable sixtyJiaziTable = null;
        if( SOUTH.contains(branch))
        {
            if (stem.equals("甲"))
                sixtyJiaziTable = SixtyJiaziTable.壬申;
            if (stem.equals("丙"))
                sixtyJiaziTable = SixtyJiaziTable.丙申;
            if (stem.equals("戊"))
                sixtyJiaziTable = SixtyJiaziTable.庚申;
            if (stem.equals("庚"))
                sixtyJiaziTable = SixtyJiaziTable.甲申;
            if (stem.equals("壬"))
                sixtyJiaziTable = SixtyJiaziTable.戊申;
        }
        else if( NORTH.contains(branch) ) {
            if (stem.equals("甲"))
                sixtyJiaziTable = SixtyJiaziTable.丙寅;
            if (stem.equals("丙"))
                sixtyJiaziTable = SixtyJiaziTable.庚寅;
            if (stem.equals("戊"))
                sixtyJiaziTable = SixtyJiaziTable.甲寅;
            if (stem.equals("庚"))
                sixtyJiaziTable = SixtyJiaziTable.戊寅;
            if (stem.equals("壬"))
                sixtyJiaziTable = SixtyJiaziTable.壬寅;
        }
        else if( EAST.contains(branch) ) {
            if (stem.equals("乙"))
                sixtyJiaziTable = SixtyJiaziTable.辛巳;
            if (stem.equals("丁"))
                sixtyJiaziTable = SixtyJiaziTable.乙巳;
            if (stem.equals("己"))
                sixtyJiaziTable = SixtyJiaziTable.己巳;
            if (stem.equals("辛"))
                sixtyJiaziTable = SixtyJiaziTable.癸巳;
            if (stem.equals("癸"))
                sixtyJiaziTable = SixtyJiaziTable.丁巳;
        }
        else if( WEST.contains(branch) ) {
            if (stem.equals("乙"))
                sixtyJiaziTable = SixtyJiaziTable.丁亥;
            if (stem.equals("丁"))
                sixtyJiaziTable = SixtyJiaziTable.辛亥;
            if (stem.equals("己"))
                sixtyJiaziTable = SixtyJiaziTable.乙亥;
            if (stem.equals("辛"))
                sixtyJiaziTable = SixtyJiaziTable.己亥;
            if (stem.equals("癸"))
                sixtyJiaziTable = SixtyJiaziTable.癸亥;
        }
        return sixtyJiaziTable;
    }

}

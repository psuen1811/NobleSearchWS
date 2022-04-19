package com.pakfortune;

import com.google.common.collect.Lists;
import com.pakfortune.common.CircularArrayList;
import com.pakfortune.common.GetBranchByStem;
import com.pakfortune.common.GetLocation;
import com.pakfortune.common.LookupImpl;
import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SixtyJiaziTable;
import com.pakfortune.model.star.*;

import java.util.List;

public class NobleSearchService extends GetLocation {

    private static final String STEM_BRANCH = "甲寅";

    public static void main(String[] args) {
        LookupImpl lookup = new LookupImpl();
        // declare 60 lunar "六十甲子"" by sequence
        List<Integer> sixJiaziList = Lists.newArrayList(SixtyJiaziTable.getSixJiaziList());
        CircularArrayList<Integer> circularArrayList = new CircularArrayList<>(sixJiaziList);
        circularArrayList.shiftRight(lookup.getIfPresent(SixtyJiaziTable.class, STEM_BRANCH).ordinal());

        GetLocation g = new GetLocation();
        String result;

        Money money = new Money();
        result = money.lookupMap("甲", Money.getMap());
        g.getLocation(result, circularArrayList, Money.getMONEY());

        Horse horse = new Horse();
        result = horse.checkStemBranch("甲", "寅").toString();
        g.getLocation(result, circularArrayList, Horse.getHORSE());

        Richman richman = new Richman();
        List<String> richmanList = richman.lookupList("甲");
        for( String s : richmanList ) {
            g.getLocation(s, circularArrayList, Richman.getRICHMAN());
        }

        RedFlower redFlower = new RedFlower();
        result = redFlower.lookupMap("寅", RedFlower.getMap());
        result = GetBranchByStem.calculate("甲", result);
        g.getLocation(result, circularArrayList, RedFlower.getRedFlower());

        SkyHappiness skyHappiness = new SkyHappiness();
        result = skyHappiness.lookupMap("寅", SkyHappiness.getMap());
        result = GetBranchByStem.calculate("甲", result);
        g.getLocation(result, circularArrayList, SkyHappiness.getSkyHappiness());
    }
}

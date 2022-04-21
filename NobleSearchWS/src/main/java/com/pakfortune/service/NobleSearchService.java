package com.pakfortune.service;

import com.google.common.collect.Lists;
import com.pakfortune.common.CircularArrayList;
import com.pakfortune.common.GetBranchByStem;
import com.pakfortune.common.GetLocation;
import com.pakfortune.common.LookupImpl;
import com.pakfortune.model.element.SixtyJiaziTable;
import com.pakfortune.model.star.*;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("ALL")
@Component
public class NobleSearchService extends GetLocation {

    public StringBuilder getNobles(String input) {
        LookupImpl lookup = new LookupImpl();
        StringBuilder stringBuilder = new StringBuilder("-------真祿馬貴人-------\n\n");
        // declare 60 lunar "六十甲子"" by sequence
        List<Integer> sixJiaziList = Lists.newArrayList(SixtyJiaziTable.getSixJiaziList());
        CircularArrayList<Integer> circularArrayList = new CircularArrayList<>(sixJiaziList);

        boolean stemBranchExists = lookup.ifInputExists(SixtyJiaziTable.class, input);

        if(!stemBranchExists) {
            return stringBuilder.append("Invalid input!");
        } else {
            // Separate stem and branch characters
            String [] stemBranchArray = input.split("", 2);
            String tempStem = stemBranchArray[0];
            String tempBranch = stemBranchArray[1];

            // 根據輸入干支飛遁六十甲子
            circularArrayList.shiftRight(lookup.getIfPresent(SixtyJiaziTable.class, input).ordinal());
            GetLocation location = new GetLocation();
            String result;

            // 找真祿干支
            Money money = new Money();
            result = money.calculate(tempStem, money.getMap());
            stringBuilder.append(location.getLocation(result, circularArrayList, money.getMONEY())).append("\n");

            // 找真馬干支
            Horse horse = new Horse();
            result = horse.checkStemBranch(tempStem, tempBranch).toString();
            stringBuilder.append(location.getLocation(result, circularArrayList, horse.getHORSE())).append("\n");

            // 找貴人干支
            Richman richman = new Richman();
            List<String> richmanList = richman.lookupList(tempStem);
            for( String s : richmanList ) {
                stringBuilder.append(location.getLocation(s, circularArrayList, richman.getRICHMAN())).append("\n");
            }

            // 真文昌
            Study study = new Study();
            result = study.calculate(tempStem, study.getMap());
            stringBuilder.append(location.getLocation(result, circularArrayList, study.getSTUDY())).append("\n");

            // 紅鸞
            RedFlower redFlower = new RedFlower();
            result = redFlower.calculate(tempBranch, redFlower.getMap());
            result = GetBranchByStem.calculate(tempStem, result);
            stringBuilder.append(location.getLocation(result, circularArrayList, redFlower.getRedFlower())).append("\n");

            // 天喜
            SkyHappiness skyHappiness = new SkyHappiness();
            result = skyHappiness.calculate(tempBranch, skyHappiness.getMap());
            result = GetBranchByStem.calculate(tempStem, result);
            stringBuilder.append(location.getLocation(result, circularArrayList, skyHappiness.getSkyHappiness())).append("\n");
        }
        return stringBuilder;
    }
}

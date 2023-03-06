package com.pakfortune.service;

import com.google.common.collect.Lists;
import com.pakfortune.common.CircularArrayList;
import com.pakfortune.common.GetBranchByStem;
import com.pakfortune.common.NoblesOutput;
import com.pakfortune.common.LookupUtils;
import com.pakfortune.model.element.SixtyJiaziTable;
import com.pakfortune.model.star.*;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("all")
@Component
public class NobleSearchService {

    public StringBuilder getNobles(String input) {
        StringBuilder stringBuilder = new StringBuilder("-------真祿馬貴人-------\n\n");
        // declare 60 lunar "六十甲子"" by sequence
        List<Integer> sixJiaziList = Lists.newArrayList(SixtyJiaziTable.getSixJiaziList());
        CircularArrayList<Integer> circularArrayList = new CircularArrayList<>(sixJiaziList);

        boolean stemBranchExists = LookupUtils.ifInputExists(SixtyJiaziTable.class, input);

        if (!stemBranchExists) {
            return stringBuilder.append("Invalid input!");
        } else {
            // Separate stem and branch characters
            String[] stemBranchArray = input.split("", 2);
            String tempStem = stemBranchArray[0];
            String tempBranch = stemBranchArray[1];

            // 根據輸入干支飛遁六十甲子
            circularArrayList.shiftRight(LookupUtils.getIfPresent(SixtyJiaziTable.class, input).ordinal());
            String result;

            // 找真祿干支
            Money money = new Money();
            result = money.lookupMap(tempStem, money.getMap());
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, money.getName())).append("\n");

            // 找真馬干支
            Horse horse = new Horse();
            result = horse.checkStemBranch(tempStem, tempBranch).toString();
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, horse.getName())).append("\n");

            // 找貴人干支
            Richman richman = new Richman();
            List<String> richmanList = richman.lookupList(tempStem);
            for (String s : richmanList) {
                stringBuilder.append(NoblesOutput.calculateAndPrint(s, circularArrayList, richman.getName())).append("\n");
            }

            // 真文昌
            Study study = new Study();
            result = study.lookupMap(tempStem, study.getMap());
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, study.getName())).append("\n");

            // 紅鸞
            RedFlower redFlower = new RedFlower();
            result = redFlower.lookupMap(tempBranch, redFlower.getMap());
            result = GetBranchByStem.calculate(tempStem, result);
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, redFlower.getName())).append("\n");

            // 天喜
            SkyHappiness skyHappiness = new SkyHappiness();
            result = skyHappiness.lookupMap(tempBranch, skyHappiness.getMap());
            result = GetBranchByStem.calculate(tempStem, result);
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, skyHappiness.getName())).append("\n");
        }
        return stringBuilder;
    }
}

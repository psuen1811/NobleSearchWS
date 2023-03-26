package com.pakfortune.service;

import com.google.common.collect.Lists;
import com.pakfortune.common.*;
import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;
import com.pakfortune.model.star.*;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("all")
@Component
public class NobleSearchService {

    public StringBuilder getNobles(String input) {
        StringBuilder stringBuilder = new StringBuilder("-------真祿馬貴人-------\n\n");
        // declare 60 lunar "六十甲子"" by sequence
        List<Integer> sixJiaziList = Lists.newArrayList(SIXTY_JIAZI_TABLE.getSixJiaziList());
        CircularArrayList<Integer> circularArrayList = new CircularArrayList<>(sixJiaziList);

        boolean stemBranchExists = LookupUtils.ifInputExists(SIXTY_JIAZI_TABLE.class, input);

        if (!stemBranchExists) {
            return stringBuilder.append("Invalid input!");
        } else {
            // Separate stem and branch characters
            String[] stemBranchArray = input.split("", 2);
            String tempStem = stemBranchArray[0];
            String tempBranch = stemBranchArray[1];

            // 根據輸入干支飛遁六十甲子
            circularArrayList.shiftRight(LookupUtils.getIfPresent(SIXTY_JIAZI_TABLE.class, input).ordinal());
            String result;

            // 找真祿干支
            result = StarMap.lookupMap(tempStem, new Money().getMap());
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, new Money().getName())).append("\n");

            // 找真馬干支
            GetResultByStemBranch horseResult = new Horse();
            result = horseResult.checkStemBranch(tempStem, tempBranch).toString();
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, new Horse().getName())).append("\n");

            // 找貴人干支
            StarList richmanStarList = new RichMan();
            List<String> richmanList = richmanStarList.lookupList(tempStem);
            for (String s : richmanList) {
                stringBuilder.append(NoblesOutput.calculateAndPrint(s, circularArrayList, new RichMan().getName())).append("\n");
            }

            // 真文昌
            result = StarMap.lookupMap(tempStem, new Study().getMap());
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, new Study().getName())).append("\n");

            // 紅鸞
            result = StarMap.lookupMap(tempBranch, new RedFlower().getMap());
            result = GetBranchByStem.calculate(tempStem, result);
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, new RedFlower().getName())).append("\n");

            // 天喜
            result = StarMap.lookupMap(tempBranch, new SkyHappiness().getMap());
            result = GetBranchByStem.calculate(tempStem, result);
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, new SkyHappiness().getName())).append("\n");
        }
        return stringBuilder;
    }
}

package com.pakfortune.service;

import com.google.common.collect.Lists;
import com.pakfortune.common.*;
import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;
import com.pakfortune.model.star.*;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("all")
@Component
/**
 * This class is a service class responsible for calculating the noble persons in Chinese astrology.
 * It encapsulates the methods of calculating the celestial stems and branches based on the input.
 */
public class NobleSearchService {

    /**
     * This method calculates the noble persons based on the input string.
     *
     * @param input A string that represents the stem and branch.
     * @return A StringBuilder containing the results of the calculation.
     */
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

            // Based on the input stem and branch, rotate the Sixty Jiazi Table.
            circularArrayList.shiftRight(LookupUtils.getIfPresent(SIXTY_JIAZI_TABLE.class, input).ordinal());
            String result;

            // Find the stem and branch for Money
            Money money = new Money();
            result = money.lookupMap(tempStem, money.getMap());
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, money.getName())).append("\n");

            // Find the stem and branch for Horse
            Horse horseResult = new Horse();
            result = horseResult.checkStemBranch(tempStem, tempBranch).toString();
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, horseResult.getName())).append("\n");

            // Find the stem and branch for Rich Man
            RichMan richman = new RichMan();
            List<String> richmanList = richman.lookupList(tempStem);
            for (String s : richmanList) {
                stringBuilder.append(NoblesOutput.calculateAndPrint(s, circularArrayList, richman.getName())).append("\n");
            }

            // Find the stem and branch for Study
            Study study = new Study();
            result = study.lookupMap(tempStem, study.getMap());
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, study.getName())).append("\n");

            // Find the stem and branch for RedFlower
            RedFlower redFlower = new RedFlower();
            result = redFlower.lookupMap(tempBranch, redFlower.getMap());
            result = GetBranchByStem.calculate(tempStem, result);
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, redFlower.getName())).append("\n");

            // Find the stem and branch for SkyHappiness
            SkyHappiness skyHappiness = new SkyHappiness();
            result = skyHappiness.lookupMap(tempBranch, skyHappiness.getMap());
            result = GetBranchByStem.calculate(tempStem, result);
            stringBuilder.append(NoblesOutput.calculateAndPrint(result, circularArrayList, skyHappiness.getName())).append("\n");
        }
        return stringBuilder;
    }
}


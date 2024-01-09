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

    CircularArrayList<Integer> circularArrayList = initializeJiaziList();

    /**
     * This method calculates the noble persons based on the input string.
     *
     * @param input A string that represents the stem and branch.
     * @return A StringBuilder containing the results of the calculation.
     */
    public StringBuilder getNobles(String input) {
        StringBuilder stringBuilder = new StringBuilder("-------真祿馬貴人-------\n\n");

        // Check if input is valid
        if (!LookupUtils.ifInputExists(SIXTY_JIAZI_TABLE.class, input)) {
            throw new IllegalArgumentException("Invalid input!");
        }

        String[] stemBranchArray = input.split("", 2);
        String stem = stemBranchArray[0];
        String branch = stemBranchArray[1];

        circularArrayList.shiftRight(LookupUtils.getIfPresent(SIXTY_JIAZI_TABLE.class, input).ordinal());

        stringBuilder.append(getNobleOutput("Money", stem, circularArrayList));
        stringBuilder.append(getNobleOutput("Horse", stem, branch, circularArrayList));
        stringBuilder.append(getRichManOutput(stem));
        stringBuilder.append(getNobleOutput("Study", stem, circularArrayList));
        stringBuilder.append(getFlowerNobleOutput("RedFlower", stem, branch, circularArrayList));
        stringBuilder.append(getFlowerNobleOutput("SkyHappiness", stem, branch, circularArrayList));

        return stringBuilder;
    }

    private CircularArrayList<Integer> initializeJiaziList() {
        List<Integer> sixJiaziList = Lists.newArrayList(SIXTY_JIAZI_TABLE.getSixJiaziList());
        return new CircularArrayList<>(sixJiaziList);
    }

    private String getFlowerNobleOutput(String nobleName, String stem, String branch, CircularArrayList<Integer> circularArrayList) {
        Star noble = createNobleByName(nobleName);
        String location = noble.lookupMap(branch, noble.getMap());
        String result = GetBranchByStem.calculate(stem, location);
        return NoblesOutput.calculateAndPrint(result, circularArrayList, noble.getName()) + "\n";
    }

    private String getNobleOutput(String nobleName, String stem, CircularArrayList<Integer> circularArrayList) {
        Star noble = createNobleByName(nobleName);
        String result = noble.lookupMap(stem, noble.getMap());
        return NoblesOutput.calculateAndPrint(result, circularArrayList, noble.getName()) + "\n";
    }

    private String getNobleOutput(String nobleName, String stem, String branch, CircularArrayList<Integer> circularArrayList) {
        Star noble = createNobleByName(nobleName);
        String result = noble.checkStemBranch(stem, branch).toString();
        return NoblesOutput.calculateAndPrint(result, circularArrayList, noble.getName()) + "\n";
    }

    private String getRichManOutput(String stem) {
        RichMan richMan = new RichMan();
        List<String> richmanList = richMan.lookupList(stem);
        StringBuilder resultBuilder = new StringBuilder();

        for (String s : richmanList) {
            resultBuilder.append(NoblesOutput.calculateAndPrint(s, circularArrayList, richMan.getName())).append("\n");
        }

        return resultBuilder.toString();
    }

    private Star createNobleByName(String nobleName) {
        switch (nobleName) {
            case "Money":
                return new Money();
            case "Horse":
                return new Horse();
            case "Study":
                return new Study();
            case "RedFlower":
                return new RedFlower();
            case "SkyHappiness":
                return new SkyHappiness();
            default:
                throw new IllegalArgumentException("Invalid noble name: " + nobleName);
        }
    }
}


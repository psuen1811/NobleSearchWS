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
        // Initialize the StringBuilder with a header
        StringBuilder stringBuilder = new StringBuilder("-------真祿馬貴人-------\n\n");

        // Check if input is valid, throw an exception if not
        if (!LookupUtils.ifInputExists(SIXTY_JIAZI_TABLE.class, input)) {
            throw new IllegalArgumentException("Invalid input!");
        }

        // Split input into stem and branch
        String[] stemBranchArray = input.split("", 2);
        String stem = stemBranchArray[0];
        String branch = stemBranchArray[1];

        // Shift the circular list based on the input
        circularArrayList.shiftRight(LookupUtils.getIfPresent(SIXTY_JIAZI_TABLE.class, input).ordinal());

        // Append results for different noble types
        stringBuilder.append(getNobleOutput("Money", stem, circularArrayList));
        stringBuilder.append(getNobleOutput("Horse", stem, branch, circularArrayList));
        stringBuilder.append(getRichManOutput(stem));
        stringBuilder.append(getNobleOutput("Study", stem, circularArrayList));
        stringBuilder.append(getFlowerNobleOutput("RedFlower", stem, branch, circularArrayList));
        stringBuilder.append(getFlowerNobleOutput("SkyHappiness", stem, branch, circularArrayList));

        return stringBuilder;
    }

    private CircularArrayList<Integer> initializeJiaziList() {
        // Create a circular list based on the Sixty Jiazi Table
        List<Integer> sixJiaziList = Lists.newArrayList(SIXTY_JIAZI_TABLE.getSixJiaziList());
        return new CircularArrayList<>(sixJiaziList);
    }

    private String getFlowerNobleOutput(String nobleName, String stem, String branch, CircularArrayList<Integer> circularArrayList) {
        // Create a noble object by name
        Star noble = createNobleByName(nobleName);

        // Lookup the branch location for the noble
        String location = noble.lookupMap(branch, noble.getMap());

        // Calculate the result based on the stem and location
        String result = GetBranchByStem.calculate(stem, location);

        // Calculate and print the noble result
        return NoblesOutput.calculateAndPrint(result, circularArrayList, noble.getName()) + "\n";
    }

    private String getNobleOutput(String nobleName, String stem, CircularArrayList<Integer> circularArrayList) {
        // Create a noble object by name
        Star noble = createNobleByName(nobleName);

        // Lookup the noble attribute based on the stem
        String result = noble.lookupMap(stem, noble.getMap());

        // Calculate and print the noble result
        return NoblesOutput.calculateAndPrint(result, circularArrayList, noble.getName()) + "\n";
    }

    private String getNobleOutput(String nobleName, String stem, String branch, CircularArrayList<Integer> circularArrayList) {
        // Create a noble object by name
        Star noble = createNobleByName(nobleName);

        // Check the stem and branch combination for the noble
        String result = noble.checkStemBranch(stem, branch).toString();

        // Calculate and print the noble result
        return NoblesOutput.calculateAndPrint(result, circularArrayList, noble.getName()) + "\n";
    }

    private String getRichManOutput(String stem) {
        // Create a RichMan object
        RichMan richMan = new RichMan();

        // Lookup the list of attributes associated with RichMan based on the stem
        List<String> richmanList = richMan.lookupList(stem);
        StringBuilder resultBuilder = new StringBuilder();

        // Append the RichMan results to the StringBuilder
        for (String s : richmanList) {
            resultBuilder.append(NoblesOutput.calculateAndPrint(s, circularArrayList, richMan.getName())).append("\n");
        }

        return resultBuilder.toString();
    }

    private Star createNobleByName(String nobleName) {
        // Create a noble object based on its name
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



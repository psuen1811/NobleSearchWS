package com.pakfortune.common;

import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;

public abstract class NoblesOutput {
    private static final int MAGIC_NUMBER = 9;

    public static String calculateAndPrint(String result, CircularArrayList<Integer> circularArrayList, String name) {
        int temp = LookupUtils.getIfPresent(SIXTY_JIAZI_TABLE.class, result).ordinal();
        int index = circularArrayList.get(temp) % MAGIC_NUMBER;

        return name + ": " + result + "在" + LookupUtils.findByValue(Direction.class, index);
    }
}

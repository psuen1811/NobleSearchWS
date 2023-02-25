package com.pakfortune.common;

import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SixtyJiaziTable;

public abstract class NoblesOutput {
    private static final int MAGIC_NUMBER = 9;

    public String calculateAndPrint(String result, CircularArrayList<Integer> circularArrayList, String name) {
        LookupImpl lookup = new LookupImpl();
        int temp = lookup.getIfPresent(SixtyJiaziTable.class, result).ordinal();
        int index = circularArrayList.get(temp) % MAGIC_NUMBER;

        return name + ": " + result + "在" + lookup.findByValue(Direction.class, index);
    }
}

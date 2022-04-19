package com.pakfortune.common;

import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SixtyJiaziTable;
import com.pakfortune.model.star.Money;

public class GetLocation {
    private static final int MAGIC_NUMBER = 9;

    public void getLocation(String result, CircularArrayList<Integer> circularArrayList, String name) {
        LookupImpl lookup = new LookupImpl();
        int temp = lookup.getIfPresent(SixtyJiaziTable.class, result).ordinal();
        int index = circularArrayList.get(temp) % MAGIC_NUMBER;

        System.out.print(name + ": ");
        System.out.println(result + "在" + lookup.findByValue(Direction.class, index));
    }
}

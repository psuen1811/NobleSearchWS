package com.pakfortune.common;

import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;

/**
 * An abstract class that provides output calculation for nobles.
 */
public abstract class NoblesOutput {
    private static final int MAGIC_NUMBER = 9;

    /**
     * Calculates a result based on the provided parameters and returns a formatted String.
     *
     * @param result the name of the SIXTY_JIAZI_TABLE enum constant
     * @param circularArrayList the list to be used for calculations
     * @param name the name to be prefixed to the output string
     * @return a formatted String that includes the name, result, and lookup value from Direction enum
     */
    public static String calculateAndPrint(String result, CircularArrayList<Integer> circularArrayList, String name) {
        // Get the enum constant with the provided result string
        SIXTY_JIAZI_TABLE sixtyJiaziTable = LookupUtils.getIfPresent(SIXTY_JIAZI_TABLE.class, result);

        // Check if the enum constant is not null before trying to use it
        if (sixtyJiaziTable != null) {
            int temp = sixtyJiaziTable.ordinal();
            int index = circularArrayList.get(temp) % MAGIC_NUMBER;
            Direction direction = LookupUtils.findByValue(Direction.class, index);

            // Check if the direction is not null before trying to use it
            if (direction != null) {
                return name + ": " + result + "在" + direction;
            }
        }

        // Return an error message if something went wrong
        return "Error: could not calculate output for " + name;
    }
}


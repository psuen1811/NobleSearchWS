package com.pakfortune.common;

import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

import static java.lang.Math.abs;

/**
 * An abstract utility class for computing branch based on stem and location.
 */
public abstract class GetBranchByStem {

    /**
     * Calculates the resultant branch based on the given stem and location.
     *
     * @param stem      The original stem (天干) to calculate the branch from.
     * @param location  The location (地支) in the branch to use in calculation.
     * @return The resultant branch composed of a stem (天干) and the location (地支).
     */
    public static String calculate(String stem, String location) {
        // Get the ordinal number of the branch (地支序數).
        int branchOrdinal = LookupUtils.getIfPresent(Branch.class, location).ordinal();

        // Compute the number of jumps to make based on the stem's ordinal
        // number and the difference between the branch's ordinal number and
        // that of the 寅 branch. The result is modulus the total number of
        // stems, yielding the new stem's ordinal number (飛遁天干序數).
        int numOfJump = (FiveTigerHop.hop(stem).ordinal() +
                (abs(branchOrdinal - Branch.寅.ordinal()) % Branch.values().length)) % Stem.values().length;

        // Return the name of the new stem (飛遁天干) combined with the location.
        return Stem.values()[numOfJump].name() + location;
    }
}


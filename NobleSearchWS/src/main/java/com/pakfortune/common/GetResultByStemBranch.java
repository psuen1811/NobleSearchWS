package com.pakfortune.common;

import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;

/**
 * An interface for classes that can check and process stem-branch pairs.
 * Classes implementing this interface can provide a way to match the combination
 * of a stem and a branch to a particular value in the SIXTY_JIAZI_TABLE.
 */
public interface GetResultByStemBranch {
    /**
     * Checks the combination of a given stem and branch and matches it to a
     * particular value in the SIXTY_JIAZI_TABLE.
     *
     * @param stem   The stem part of a stem-branch pair.
     * @param branch The branch part of a stem-branch pair.
     * @return The corresponding SIXTY_JIAZI_TABLE value for the given stem and branch.
     */
    SIXTY_JIAZI_TABLE checkStemBranch(String stem, String branch);
}


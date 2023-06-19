package com.pakfortune.common;

import java.util.List;

/**
 * An interface for classes that can look up a list based on a string input, while
 * also extending the Star interface.
 * Implementations of this interface represent entities that associate a list
 * of strings with a certain Star input.
 */
public interface StarList extends Star {
    /**
     * Looks up a list of strings associated with the provided input.
     *
     * @param input The string input to look up.
     * @return The list of strings associated with the input.
     */
    List<String> lookupList(String input);
}


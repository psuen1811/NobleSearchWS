package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;

import java.util.List;

/**
 * Represents an interface for a star object.
 */
public interface Star {

    /**
     * Gets the name of the star.
     *
     * @return The name of the star.
     */
    String getName();

    /**
     * Performs a lookup operation based on the input and returns a list of strings.
     *
     * @param input The input for the lookup.
     * @return A list of strings resulting from the lookup operation.
     */
    List<String> lookupList(String input);

    /**
     * Gets an immutable map of string key-value pairs.
     *
     * @return An immutable map containing string key-value pairs.
     */
    ImmutableMap<String, String> getMap();

    /**
     * Performs a lookup operation based on the input using a key-value mapper and returns a string result.
     *
     * @param <K>    The type of the input key.
     * @param <V>    The type of the input value.
     * @param input  The input for the lookup.
     * @param mapper The immutable map used for the lookup operation.
     * @return The result of the lookup operation as a string.
     */
    <K, V> String lookupMap(K input, ImmutableMap<K, V> mapper);

    /**
     * Checks the stem and branch of the star using a specific table.
     *
     * @param stem   The stem of the star.
     * @param branch The branch of the star.
     * @return A result based on the stem and branch check using the specified table.
     */
    SIXTY_JIAZI_TABLE checkStemBranch(String stem, String branch);
}



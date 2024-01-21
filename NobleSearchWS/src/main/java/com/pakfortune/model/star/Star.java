package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;

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
    default <K, V> String lookupMap(K input, ImmutableMap<K, V> mapper)
    {
        V value = mapper.get(input);
        return value != null ? value.toString() : null;
    }

    /**
     * Checks the stem and branch of the star using a specific table.
     *
     * @param stem   The stem of the star.
     * @param branch The branch of the star.
     * @return A result based on the stem and branch check using the specified table.
     */
    default SIXTY_JIAZI_TABLE checkStemBranch(String stem, String branch)
    {
        return null;
    }
}



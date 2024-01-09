package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.model.element.SIXTY_JIAZI_TABLE;

import java.util.List;

/**
 * An interface representing a Star entity.
 * Implementations of this interface represent entities that have a name property,
 * such as a Star in the context of astronomy or astrology.
 */
public interface Star {
    /**
     * Retrieves the name of the Star entity.
     *
     * @return The name of the Star as a String.
     */
    String getName();
    List<String> lookupList(String input);
    ImmutableMap<String, String> getMap();
    <K, V> String lookupMap(K input, ImmutableMap<K, V> mapper);
    SIXTY_JIAZI_TABLE checkStemBranch(String stem, String branch);

}


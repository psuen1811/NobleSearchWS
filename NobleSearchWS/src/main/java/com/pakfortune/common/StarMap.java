package com.pakfortune.common;

import com.google.common.collect.ImmutableMap;

/**
 * An interface for the mapping of stars. It extends the Star interface.
 */
public interface StarMap extends Star {

    /**
     * Given an input and a map, this method retrieves the value from the map
     * that corresponds to the input and returns it as a String.
     *
     * @param input The key for which to look up a value in the map.
     * @param mapper An ImmutableMap that provides mappings of keys to values.
     * @return The value that corresponds to the input key in the map,
     *         represented as a String, or null if the key does not exist in the map.
     */
    default <K, V> String lookupMap(K input, ImmutableMap<K, V> mapper) {
        V value = mapper.get(input);
        return value != null ? value.toString() : null;
    }
}



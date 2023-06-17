package com.pakfortune.common;

import com.google.common.collect.ImmutableMap;

public interface StarMap extends Star {

    default <K, V> String lookupMap(K input, ImmutableMap<K, V> mapper) {
        V value = mapper.get(input);
        return value != null ? value.toString() : null;
    }
}


package com.pakfortune.common;

import com.google.common.collect.ImmutableMap;

public interface StarMap {

    default <K, V> String lookupMap(K input, ImmutableMap<K, V> mapper) {
        return mapper.get(input).toString();
    }
}

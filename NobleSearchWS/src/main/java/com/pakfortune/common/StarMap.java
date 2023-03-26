package com.pakfortune.common;

import com.google.common.collect.ImmutableMap;

public abstract class StarMap {

    public static String lookupMap(String input, ImmutableMap<String, String> mapper) {
        return mapper.get(input);
    }
}

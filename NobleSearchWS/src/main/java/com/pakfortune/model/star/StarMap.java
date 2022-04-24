package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;

public abstract class StarMap {

    public String lookupMap(String input, ImmutableMap<String, String> mapper) {
        return mapper.get(input);
    }
}

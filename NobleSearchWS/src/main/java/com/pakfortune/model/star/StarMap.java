package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;

public class StarMap {

    StarMap() {}

    public String calculate(String input, ImmutableMap<String, String> mapper) {
        return mapper.get(input);
    }
}

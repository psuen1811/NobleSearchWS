package com.pakfortune.common;

import com.google.common.collect.ImmutableMap;

public class GetInformation {

    public String lookupMap(String input, ImmutableMap<String, String> mapper) {
        return mapper.get(input);
    }
}

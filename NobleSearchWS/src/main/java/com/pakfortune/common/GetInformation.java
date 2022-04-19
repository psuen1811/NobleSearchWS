package com.pakfortune.common;

import java.util.HashMap;

public class GetInformation {

    public String lookupMap(String input, HashMap<String, String> mapper) {
        return mapper.get(input);
    }
}

package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.pakfortune.common.Star;
import com.pakfortune.common.StarMap;

@SuppressWarnings("all")
/**
 * Represents the Study star in the Star Map.
 */
public class Study implements Star {

    // Defining constant for the star's name
    private static final String STUDY = "文昌";
    // A map that associates each stem with a branch that makes up a Study combination
    private static final ImmutableMap<String, String> MAP;

    static {
        MAP = ImmutableMap.<String, String>builder()
                .put("甲", "己巳")
                .put("乙", "壬午")
                .put("丙", "丙申")
                .put("丁", "己酉")
                .put("戊", "庚申")
                .put("己", "癸酉")
                .put("庚", "丁亥")
                .put("辛", "庚子")
                .put("壬", "壬寅")
                .put("癸", "乙卯")
                .build();
    }

    /**
     * Returns the map that associates each stem with a branch that makes up a Study combination.
     */
    public static ImmutableMap<String, String> getMap() {
        return MAP;
    }

    /**
     * Returns the name of the star, which is "文昌".
     */
    @Override
    public String getName() {
        return STUDY;
    }
}


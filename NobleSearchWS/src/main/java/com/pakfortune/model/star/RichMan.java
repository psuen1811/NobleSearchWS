package com.pakfortune.model.star;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.pakfortune.common.StarList;

import java.util.List;

/**
 * Represents a Rich Man in the Star List.
 */
public class RichMan implements StarList {

    // The name of the star
    private static final String RICH_MAN = "貴人";
    // A multimap that associates each stem with a list of branches that make up a Rich Man combination
    private static final ImmutableMultimap<String, String> LIST;

    static {
        ArrayListMultimap<String, String> list = ArrayListMultimap.create();
        list.put("甲", "丁丑");
        list.put("甲", "辛未");
        list.put("乙", "甲申");
        list.put("乙", "戊子");
        list.put("丙", "丁酉");
        list.put("丙", "己亥");
        list.put("丁", "己酉");
        list.put("丁", "辛亥");
        list.put("戊", "乙丑");
        list.put("戊", "己未");
        list.put("己", "丙子");
        list.put("己", "壬申");
        list.put("庚", "己丑");
        list.put("庚", "癸未");
        list.put("辛", "甲午");
        list.put("辛", "庚寅");
        list.put("壬", "乙巳");
        list.put("壬", "癸卯");
        list.put("癸", "乙卯");
        list.put("癸", "丁巳");
        LIST = ImmutableMultimap.copyOf(list);
    }

    /**
     * Returns the name of the star, which is "貴人".
     */
    @Override
    public String getName() {
        return RICH_MAN;
    }

    /**
     * Returns a list of branches that make up a Rich Man combination for a given stem.
     */
    @Override
    public List<String> lookupList(String input) {
        return ImmutableList.copyOf(LIST.get(input));
    }
}


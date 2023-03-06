package com.pakfortune.model.star;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.pakfortune.common.Star;
import com.pakfortune.common.StarList;

import java.util.List;

public class Richman implements StarList, Star {

    // The name of the star
    private static final String RICHMAN = "貴人";
    // A multimap that associates each stem with a list of branches that make up a Richman combination
    private static final ArrayListMultimap<String, String> list = ArrayListMultimap.create();

    // Populate the multimap with the different combinations of stems and branches that make up a Richman
    static {
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
    }

    // Get the name of the star
    @Override
    public String getName() {
        return RICHMAN;
    }

    // Lookup a list of branches that make up a Richman combination for a given stem
    public List<String> lookupList(String input) {
        return ImmutableList.copyOf(list.get(input));
    }
}

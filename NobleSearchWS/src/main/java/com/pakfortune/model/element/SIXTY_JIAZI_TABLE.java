package com.pakfortune.model.element;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the Sixty Jiazi Table, which is a cyclic list of 60 pairs of Heavenly Stems and Earthly Branches
 * used in Chinese astrology.
 */
public enum SIXTY_JIAZI_TABLE {
    甲子, 乙丑, 丙寅, 丁卯, 戊辰, 己巳, 庚午, 辛未, 壬申, 癸酉,
    甲戌, 乙亥, 丙子, 丁丑, 戊寅, 己卯, 庚辰, 辛巳, 壬午, 癸未,
    甲申, 乙酉, 丙戌, 丁亥, 戊子, 己丑, 庚寅, 辛卯, 壬辰, 癸巳,
    甲午, 乙未, 丙申, 丁酉, 戊戌, 己亥, 庚子, 辛丑, 壬寅, 癸卯,
    甲辰, 乙巳, 丙午, 丁未, 戊申, 己酉, 庚戌, 辛亥, 壬子, 癸丑,
    甲寅, 乙卯, 丙辰, 丁巳, 戊午, 己未, 庚申, 辛酉, 壬戌, 癸亥;

    // A list of the ordinal values of the enum constants
    private static final List<Integer> VALUES = Collections.unmodifiableList(
            Arrays.stream(SIXTY_JIAZI_TABLE.values())
                    .map(Enum::ordinal)
                    .collect(Collectors.toList()));

    /**
     * Returns an unmodifiable list of the ordinal values of the enum constants.
     */
    public static List<Integer> getSixJiaziList() {
        return VALUES;
    }
}

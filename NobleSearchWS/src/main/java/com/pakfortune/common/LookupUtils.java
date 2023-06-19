package com.pakfortune.common;

import com.google.common.base.Enums;

import java.util.EnumSet;

/**
 * Utility class for Enum Lookup operations.
 */
public abstract class LookupUtils {

    /**
     * Returns the Enum constant of the specified enum type, if present.
     *
     * @param clazz the class of the enum
     * @param name the name of the enum constant
     * @return the Enum constant, or null if not present
     */
    public static <E extends Enum<E>> E getIfPresent(Class<E> clazz, String name) {
        return Enums.getIfPresent(clazz, name).orNull();
    }

    /**
     * Checks if the provided input exists as a constant in the specified enum class.
     *
     * @param clazz the class of the enum
     * @param value the name of the enum constant
     * @return true if the input exists as a constant, false otherwise
     */
    public static <E extends Enum<E>> boolean ifInputExists(Class<E> clazz, String value) {
        return EnumSet.allOf(clazz).stream()
                .anyMatch(e -> e.name().equals(value));
    }

    /**
     * Returns the Enum constant of the specified enum type with the provided index.
     * Returns null if the index is out of bounds.
     *
     * @param clazz the class of the enum
     * @param value the index of the enum constant
     * @return the Enum constant, or null if the index is out of bounds
     */
    public static <E extends Enum<E>> E findByValue(Class<E> clazz, int value) {
        E[] enumConstants = clazz.getEnumConstants();
        if (value < 0 || value >= enumConstants.length) {
            return null;
        }
        return enumConstants[value];
    }
}

package com.pakfortune.common;

import com.google.common.base.Enums;

import java.util.EnumSet;

/*
 Validate and Lookup
 */
@SuppressWarnings("all")
public abstract class LookupUtils {

    public static <E extends Enum<E>> E getIfPresent(Class<E> clazz, String name) {
        return Enums.getIfPresent(clazz, name).orNull();
    }

    public static <E extends Enum<E>> boolean ifInputExists(Class<E> clazz, String value) {
        try {
            return EnumSet.allOf(clazz).contains(Enum.valueOf(clazz, value));
        } catch (Exception e) {
            return false;
        }
    }

    public static <E extends Enum<E>> E findByValue(Class<E> clazz, int value) {
        return clazz.getEnumConstants()[value];
    }
}
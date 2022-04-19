package com.pakfortune.common;

import com.google.common.base.Enums;

import java.util.EnumSet;

/*
 Validate and Lookup
 */
public class LookupImpl implements LookupInterface {

    @Override
    public <E extends Enum<E>> E getIfPresent(Class<E> clazz, String name) {
        return Enums.getIfPresent(clazz, name).orNull();
    }

    @Override
    public <E extends Enum<E>> boolean ifInputExists(Class<E> clazz, String value) {
        try {
            return EnumSet.allOf(clazz).contains(Enum.valueOf(clazz, value));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public <E extends Enum<E>> E findByValue(Class<E> clazz, int value) {
        return clazz.getEnumConstants()[value];
    }
}
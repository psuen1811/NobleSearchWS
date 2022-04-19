package com.pakfortune.common;

public interface LookupInterface {

    <E extends Enum<E>> E getIfPresent(Class<E> clazz, String name);

    <E extends Enum<E>> boolean ifInputExists(Class<E> clazz, String value);

    <E extends Enum<E>> E findByValue(Class<E> clazz, int value);

}

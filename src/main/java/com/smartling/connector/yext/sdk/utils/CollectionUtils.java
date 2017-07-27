package com.smartling.connector.yext.sdk.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CollectionUtils
{

    private CollectionUtils()
    {

    }

    public static <T> Stream<T> stream(Collection<T> collection)
    {
        return Optional.ofNullable(collection).orElseGet(Collections::emptyList).stream();
    }

    public static <T> Stream<T> parallelStream(Collection<T> collection)
    {
        return stream(collection).parallel();
    }

    public static <T, R> List<R> map(List<T> collection, Function<T, R> mapper)
    {
        return stream(collection).map(mapper).collect(Collectors.toList());
    }

    public static <T> T first(Collection<? extends T> collection)
    {
        final T notFound = null;
        return isEmpty(collection) ? notFound : collection.iterator().next();
    }

    public static <T> boolean isEmpty(Collection<? extends T> collection)
    {
        return size(collection) == 0;
    }

    public static int size(Collection<?> collection)
    {
        return collection != null ? collection.size() : 0;
    }

    public static <T> boolean isEmpty(T[] array)
    {
        return array == null || array.length == 0;
    }

    public static <T> int size(T[] array)
    {
        return array == null ? 0 : array.length;
    }

    public static <T> Map<String, T> toMap(List<T> list, Function<T, String> getId)
    {
        return stream(list).collect(Collectors.toMap(getId, Function.identity()));
    }

    public static <T> Set<String> toSet(List<T> list, Function<T, String> getId)
    {
        return stream(list).map(getId).collect(Collectors.toSet());
    }

}

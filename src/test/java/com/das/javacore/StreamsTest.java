package com.das.javacore;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Java streams feature
 */
public class StreamsTest {
    List<String> list;

    @Before
    public void init() {
        System.out.println("init");
        list = Arrays.asList("First", "Second", "Third", "Fourth");
    }

    @Test
    public void testFindAny() {

        list.stream().filter(Predicate.isEqual("A")).forEach(System.out::println);
        Optional<String> optional = list.stream().findAny();

        //Test if the result is not empty
        assertTrue(optional.isPresent());
        //Test if the result has any one value of the items in the list
        assertThat(optional.get(), anyOf(is("First"), is("Second"), is("Third"), is("Fourth")));

        Optional<String> optionalFindFirst = list.stream().findFirst();

    }

    @Test
    public void testFindFirst() {
        //Test if the result is not empty
        Optional<String> result = list.stream().findFirst();
        assertTrue(result.isPresent());

        assertEquals(result.get(), "First");
    }

    @Test
    public void testAllMatch() {
        //Test all items in the list match the predicate
        assertTrue(list.stream().allMatch(Predicate.not(Predicate.isEqual("abc"))));
        assertFalse(list.stream().allMatch(Predicate.not(Predicate.isEqual("First"))));
    }

    @Test
    public void testConvertListToSet() {
        //Using collector to convert List to Set
        list = Arrays.asList("First", "Second", "Third", "Fourth", "Fourth");
        Set set = list.stream().collect(Collectors.toSet());
        assertEquals(set.stream().count(), 4);
    }

    /**
     * Average the elements in a collection
     */
    @Test
    public void testAverageUsingCollector() {
        list = Arrays.asList("2", "2", "3", "4", "4");
        ToIntFunction<String> toIntFunction = x -> Integer.parseInt(x);
        list.stream().collect(Collectors.averagingInt(toIntFunction));
        assertEquals(list.stream().collect(Collectors.averagingInt(toIntFunction)), Double.valueOf(3));
    }
}

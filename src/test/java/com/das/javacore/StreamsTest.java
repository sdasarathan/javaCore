package com.das.javacore;

import org.junit.Before;
import org.junit.Test;

import java.time.temporal.Temporal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /*
    Find any item in the list.
    In a non-parallel operation, it will most likely return the first element in the Stream but there is no guarantee for this.
     */
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
        list = Arrays.asList("2", "2", "4", "4");
        ToIntFunction<String> toIntFunction = x -> Integer.parseInt(x);
        list.stream().collect(Collectors.averagingInt(toIntFunction));
        assertEquals(list.stream().collect(Collectors.averagingInt(toIntFunction)), Double.valueOf(3));
    }

    /*
    Grouping in Streams
     */
    @Test
    public void test() {
        List<Employee> employees = List.of(new Employee("Bob", 29), new Employee("Alice", 20), new Employee("John", 29));

       Map groupedMap = employees.stream().collect(Collectors.groupingBy(e -> e.age));
       groupedMap.forEach((age, e) -> System.out.println( "age" + age + ":" + "Employee" + e));
    }

    class Employee{
        String name;
        int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

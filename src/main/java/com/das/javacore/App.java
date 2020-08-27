package com.das.javacore;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        List<String> list = Arrays.asList("First", "Second", "Third", "Fourth");
        list.stream().filter(Predicate.isEqual("A")).forEach(System.out::println);
        Optional<String> optional = list.stream().findAny();
        System.out.println(optional.get());

        Optional<String> optionalFindFirst = list.stream().findFirst();
        System.out.println(optionalFindFirst.get());

    }
}

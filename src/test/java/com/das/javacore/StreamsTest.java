package com.das.javacore;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Unit test for simple App.
 */
public class StreamsTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testStream(){
        List<String> list = Arrays.asList("First", "Second", "Third", "Fourth");
        list.stream().filter(Predicate.isEqual("A")).forEach(System.out::println);
        Optional<String> optional = list.stream().findAny();

        //Test if the result is not empty
       assertTrue(optional.isPresent());
       //Test if the result has any one value of the items in the list
       assertThat(optional.get(), anyOf(is("First"),is("Second"),is("Third"),is("Fourth")));

        Optional<String> optionalFindFirst = list.stream().findFirst();

    }
}

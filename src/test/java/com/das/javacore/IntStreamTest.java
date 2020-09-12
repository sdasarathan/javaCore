package com.das.javacore;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;

public class IntStreamTest {

    //Sum all elements in list
    @Test
    public void sumItemInList() {
        int[] a = {1, 2, 3};
        int sum = IntStream.of(a).sum();
        Assert.assertEquals(sum, 6);
    }

    /*
    Reduce function performs given  function cumulatively on elements in the IntStream
     */
    @Test
    public void reduceIntStream() {
        int[] x = {1, 2, 3, 4};
        OptionalInt sum = IntStream.of(x).reduce((a, b) -> (a + b) * 2);
        Assert.assertEquals(sum.getAsInt(), 44);
    }

    //TODO
//    @Test
//    public void distinctIntStream1() {
//        int[] x = {1, 2, 3, 4, 1, 2, 3, 4};
//        IntStream.of(x).distinct().forEach(z -> System.out.println(z));
//        List l = IntStream.of(x).distinct().boxed().collect(Collectors.toList());
//        Assert.assertThat(l, contains(hasItems(Integer.valueOf(1))));
//    }
}

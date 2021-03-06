package com.das.hackerrank;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Hackerrank problem mode with java streams.
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
public class BirthdayCake {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        Map<Integer, Long> frequencies = candles.stream().collect(Collectors.groupingBy(integer -> integer, Collectors.counting()));
        Integer value = frequencies.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getKey();
        System.out.println(frequencies.get(value));

        return frequencies.get(value).intValue();
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = BirthdayCake.birthdayCakeCandles(candles);
//
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();

        bufferedReader.close();
//            bufferedWriter.close();
    }
}


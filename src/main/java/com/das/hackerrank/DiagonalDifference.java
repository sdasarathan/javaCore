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
 * Hacker rank problem solving
 * https://www.hackerrank.com/challenges/diagonal-difference/problem?h_r=next-challenge&h_v=zen
 * */
class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        Integer primary = IntStream.range(0,arr.size()).map(i -> arr.get(i).get(i)).sum();
        Integer secondary = IntStream.range(0,arr.size()).map(i -> arr.get(i).get(arr.get(i).size()-i -1)).sum();
        System.out.println(Math.abs(primary-secondary));
        return Math.abs(primary-secondary);
    }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

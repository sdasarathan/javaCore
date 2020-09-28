package com.das.hackerrank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hacker rank problem solving
 * https://www.hackerrank.com/challenges/mini-max-sum/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class MinMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        IntStream intStream = Arrays.stream(arr).sorted();
        List<Integer> minSumLIst = intStream.boxed().collect(Collectors.toList());
        List<Integer> maxSumList = new ArrayList<>(minSumLIst);
        minSumLIst.remove(minSumLIst.size()-1);
        minSumLIst.forEach(System.out::println);
        Long minSum = minSumLIst.stream().mapToLong(Integer::longValue).sum();

        maxSumList.remove(0);
        long maxSum = maxSumList.stream().mapToLong(Integer::longValue).sum();
        maxSumList.forEach(System.out::println);
        System.out.println(minSum + " " + maxSum);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

package com.das.hackerrank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hackerrank Plus minus problem
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */
public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float positiveRatio =  (float) Arrays.stream(arr).filter(s -> s > 0).count() / (float) arr.length;
        float negativeRatio = (float)Arrays.stream(arr).filter(s -> s < 0).count() / (float)arr.length;
        float neutralRatio = (float)Arrays.stream(arr).filter(s -> s == 0).count() / (float)arr.length;
        System.out.println(BigDecimal.valueOf(positiveRatio).setScale(5, BigDecimal.ROUND_DOWN));
        System.out.println(BigDecimal.valueOf(negativeRatio).setScale(5, BigDecimal.ROUND_DOWN));
        System.out.println(BigDecimal.valueOf(neutralRatio).setScale(5, BigDecimal.ROUND_DOWN));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}


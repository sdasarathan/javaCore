package com.das.hackerrank;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Hackerrank Plus minus problem
 * https://www.hackerrank.com/challenges/time-conversion/problem?isFullScreen=true
 */
class Result1 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        DateFormat df = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
        String  output = null;
        try {
            Date date = df.parse(s);
            output = outputformat.format(date);
            System.out.println(output);
        } catch (ParseException e) {
            System.out.println("Exception while trying to parse date");
        }
        return output;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result1.timeConversion(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

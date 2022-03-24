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

 class Result4 {

        /*
         * Complete the 'gradingStudents' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY grades as parameter.
         *
         * https://www.hackerrank.com/challenges/grading/problem?isFullScreen=true
         */

        public static List<Integer> gradingStudents(List<Integer> grades) {
            // Write your code here
            grades=grades.stream().map(p -> {
                if(p<38){
                    return p;
                }else{
                    if(p % 5 >=3){
                        return p + 5 - (p % 5);
                    }else{
                        return p;
                    }
                }
            }).collect(Collectors.toList());
            grades.forEach(s -> System.out.println(s.toString()));
            return grades;
        }

    }

    public class Grading {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result4.gradingStudents(grades);

//            bufferedWriter.write(
//                    result.stream()
//                            .map(Object::toString)
//                            .collect(joining("\n"))
//                            + "\n"
//            );

            bufferedReader.close();
//            bufferedWriter.close();
        }
    }


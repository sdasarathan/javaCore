package com.das.javacore;

import java.util.HashMap;
import java.util.Map;

/**
 * compute method in map provides a way to reassign value after performing operation based on key and value
 */
public class MapCompute {
    public static void main( String[] args )
    {
        Map<String, Long> employeeSalary = new HashMap<>();

//        Give Bob 30000 as a salary
        employeeSalary.put("Bob", 30000L);

        System.out.println(employeeSalary.get("Bob"));

//        Lets increament Bob's salary by 1000
        employeeSalary.compute("Bob", (k,v) ->  v + 1000L);

//       Bob salary in now modified  Value
        System.out.println(employeeSalary.get("Bob"));
    }
}

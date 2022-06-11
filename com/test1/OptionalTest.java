package com.test1;

import java.util.Optional;

public class OptionalTest {

    public static void main (String a[]){

        String str = "Akhilesh";

        Optional<String> opt = Optional.of(str);
        System.out.println(opt);
        Optional<Integer> opt1= Optional.empty();
        //opt1.get();

        Integer val = opt1.orElseGet(()-> 12);




    }
}

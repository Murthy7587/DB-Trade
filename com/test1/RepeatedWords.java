package com.test1;


//[abc, bca, abc, saw,Cisco, amazom, abc, cisco,amazon]

import java.util.HashMap;
import java.util.Map;

public class RepeatedWords {

    public static String mostRepeatedWords(String a[]){
        HashMap<String,Integer> mapCount = new HashMap<String,Integer>();

        int firstmax=Integer.MIN_VALUE;
        int secondmax=Integer.MIN_VALUE;
        for(String str:a){
            mapCount.put(str,mapCount.getOrDefault(str,0)+1);
        }


        int count=0;
        String key=null;
        for( Map.Entry<String,Integer> e: mapCount.entrySet()){

            if(e.getValue() > firstmax){
                secondmax=firstmax;
                firstmax=e.getValue();
            }
            else if(e.getValue() > secondmax){
                secondmax=e.getValue();
            }
        }

        return key;
    }

    public static void main (String a[]){

        String [] str = {"abc", "bca", "abc", "saw","cisco", "amazom", "abc", "cisco","amazon"};
        System.out.println(mostRepeatedWords(str));
    }
}

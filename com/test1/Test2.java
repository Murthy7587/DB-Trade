package com.test1;

public class Test2 {

    //str=abcd
    // a
    //ab
    //abc
    //abcd
    //b

    public static void printSubstring(String str){

        int n = str.length();
        for(int i=0;i<n;i++){
            String substr = "";
            for(int j=i;j<n;j++){
                substr+=str.charAt(j);
                System.out.println(substr);
            }
        }
    }

    public static void main (String a[]){
        printSubstring("abcd");
    }
}

package com.test1;

//a1= [1,2,4,5,6,7,0,0,0,0,0,0]
//a2=[0,2,4,6,8,9]

//index=5- to indicate the index after which 0 starts
//final a1 = [0,1,2,2,4,4,5,6,6,7,8,9]

import java.util.Arrays;




class ArrayMerge {

    public static void merge(int a1[],int a2[],int index){

        Integer a = new Integer(12);
        int i=index;
        int j=a2.length-1;
        int k=a1.length-1;

        while(j >= 0){
            if(i>= 0 && a1[i] > a2[j]){
                a1[k]=a1[i];
                i--;
                k--;
            }
            else{
                a1[k]=a2[j];
                k--;
                j--;
            }
        }
    }

    public static void main (String a[]){

        int [] a1 = {1,2,4,5,6,7,0,0,0,0,0,0};
        int [] a2 = {0,2,4,6,8,9};
        //Sayable s = (a1,a2) -> merge(a1,a2);
        //Arrays.stream(a1).allMatch(System.out.println);
    }
}

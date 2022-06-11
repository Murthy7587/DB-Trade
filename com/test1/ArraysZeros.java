package com.test1;

//I/P=[1,1,1,0,1,1,0,1]
//1st Iteration [0,1,1,1,1,1,0,1]
//2nd Itreation [0,0,1,1,1,1,1,1]
//O/P=[0,0,1,1,1,1,1,1]
public class ArraysZeros {


    public static void moveZeros(int [] a){

        int i=0;
        int j=0;
        int size = a.length;

        while (i<size){
            if(a[i]==1){
                i++;
            }
            else{
                a[j]=0;
                a[i]=1;
                j++;
            }
        }

    }

    public static void main(String a[]){

        int b[] = {1,1,1,1,1,1,0,0,0};
        //ArraysZeros::moveZeros(b);
    }
}

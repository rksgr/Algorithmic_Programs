
package com.mycompany.dec_23_algorithms;

import java.util.Arrays;


public class InsertionSort {
    public static void insertionSortAlgo(String []arr){
        for (int i=0;i<arr.length-1;i++){
            String comp_str = arr[i+1];
            // If the String to be compared is less than first element
            if (comp_str.compareTo(arr[0]) < 0){
                for (int k=i+1;k>0;k--){
                    String temp_str = arr[k];
                    arr[k] = arr[k-1];
                    arr[k-1] = temp_str;
                }
            }
            else {
                for (int j=i;j>0;j--){
                    // If test string is greater than j-1 th string but less than jth string
                    if (comp_str.compareTo(arr[j]) < 0){
                        if (comp_str.compareTo(arr[j-1]) > 0){
                            // Bring test string to jth position by shifting each element 
                            // from j to i+1 by one place right
                            for (int k=i+1;k>j;k--){
                                String temp_str = arr[k];
                                arr[k] = arr[k-1];
                                arr[k-1] = temp_str;
                            }               
                        }
                    }
                }   
            }
        }
        System.out.println("The array after insertion sort is: "+ Arrays.toString(arr));
    }
    
    public static void main(String []args){
        String []arr = {"mumbai","bengaluru","guwahati","patna","panaji","thiruvananthpuram"};
        insertionSortAlgo(arr);
    }
}

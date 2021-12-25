
package com.mycompany.dec_23_algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSortInt(int []arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp_int = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp_int;
                }
            }
        }
        System.out.println("Elements of array after bubble sort are: "
                + Arrays.toString(arr));
    }
    public static void main(String []args){
        int []arr = {1,2,7,0,-3,89,-32,27};
        bubbleSortInt(arr);
    }
}

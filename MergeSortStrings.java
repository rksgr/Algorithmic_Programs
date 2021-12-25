
package com.mycompany.dec_23_algorithms;

import java.util.Arrays;


public class MergeSortStrings {
    public static String[] mergeSortTest(String[] arr){
        String []merge_sort_arr = arr;
        // Split array until it has not more than 2 elements left
        if (arr.length>=2){
            String []split_arr1 = Arrays.copyOfRange(arr,0,arr.length/2);
            String []split_arr2 = Arrays.copyOfRange(arr,arr.length/2,arr.length);
            
            if ((split_arr1.length>1) && (split_arr2.length>1)){
                String [] sort_split_arr1 = mergeSortTest(split_arr1);
                String [] sort_split_arr2 = mergeSortTest(split_arr2);
                String [] merged_arr = merge(sort_split_arr1, sort_split_arr2);
                merge_sort_arr = sort(merged_arr);
            }
            else if ((split_arr1.length>=1) && (split_arr2.length<=1)){
                String [] sort_split_arr1 = mergeSortTest(split_arr1);
                String [] merged_arr = merge(sort_split_arr1, split_arr2);
                merge_sort_arr = sort(merged_arr);
            }
            else if ((split_arr1.length<=1) && (split_arr2.length>=1)){
                String [] sort_split_arr2 = mergeSortTest(split_arr2);
                String [] merged_arr = merge(split_arr1, sort_split_arr2);
                merge_sort_arr = sort(merged_arr);
            }
            else if ((split_arr1.length<=1) && (split_arr2.length<=1)){
                String [] merged_arr = merge(split_arr1, split_arr2);
                merge_sort_arr = sort(merged_arr);
            }
        }else if (arr.length<2){
            merge_sort_arr = arr;
        } 
    return merge_sort_arr;
    }
    // sort the elements of the array
    public static String []sort(String []arr){
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                if (arr[j].compareTo(arr[i]) < 0){
                    String temp_num = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp_num;
                }
            }
        }
        return arr;
    }
    // Merge elements of 2 arrays
    public static String[] merge(String []arr1, String[]arr2){
        int a1 = arr1.length;
        int a2 = arr2.length;
        int a3 = a1 + a2;
        String []merge_arr = new String [a3];
        System.arraycopy(arr1, 0, merge_arr, 0, a1);
        System.arraycopy(arr2, 0, merge_arr, a1, a2);
        return merge_arr;
    }
    
    public static void main(String []args){
        String []arr = {"mango","plum","cashew","cassava","raisin","grape","almond"};
        System.out.println("Array after Merge Sort: "+
                Arrays.toString(mergeSortTest(arr)));
    }
}


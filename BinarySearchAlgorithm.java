
package com.mycompany.dec_23_algorithms;

import java.util.Arrays;

public class BinarySearchAlgorithm {
    // Using recursive method to search an elemnt in an array
    public static void binarySearchStr(String srch_elemt,String[] arrBin){
        System.out.println("Searching in the Array :" + Arrays.toString(arrBin));
        
        int r = arrBin.length/2;
        // If search element equals middle element
        if (srch_elemt.equals(arrBin[r])){
            System.out.println("Search element found.");
        }
        else if (srch_elemt.compareTo(arrBin[r])>0){
            
            if (arrBin.length >1){
                // search in second half
                String [] arr_new = Arrays.copyOfRange(arrBin, r, arrBin.length);
                binarySearchStr(srch_elemt,arr_new);
            }
            else if (arrBin.length<=1){
                System.out.println("Element not found.");
            }
        } else if (srch_elemt.compareTo(arrBin[r])<0){
            
            if (arrBin.length >1){
            // Search in first half
            String []arr_new = Arrays.copyOfRange(arrBin,0,r);
            binarySearchStr(srch_elemt,arr_new);
            }
            else if (arrBin.length<=1){
                System.out.println("Element not found.");
            }
        } 
    }
    
    public static void main(String []args){
        String[] arr = {"Mango","Guava","Plum","Grapes","Sugarcane"};
        Arrays.sort(arr);
        binarySearchStr("Plum",arr);        
    }
}

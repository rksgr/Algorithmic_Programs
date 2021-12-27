
package com.mycompany.dec_23_algorithms;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class FindPrime {
    /*
    Question 8: Prime numbers in the range of 1 to 1000
    */
    public static ArrayList<Integer> findPrime(int nums){
        //int []arr_prime = new int[]();
        ArrayList<Integer> arr_prime = new ArrayList<>();
        for (int i=2;i<=nums;i++){
            Boolean if_prime = true;
            for (int j=2;j<=i/2;j++){
                if (i%j==0){
                    if_prime = false;
                    break;
                }
            }
            if (if_prime==true){
                arr_prime.add(i);
            }
        }
        System.out.println("The prime numbers in the range of 0 to "+nums+ " are:");
        for (int k=0;k<arr_prime.size();k++){
            System.out.print(arr_prime.get(k)+" ");
        }
        return arr_prime;
    }
    public static void main(String []args){
        findPrime(1000);
    }
}

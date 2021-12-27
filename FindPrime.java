
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
    /*
    Question 9: Find Prime numbers which are anagram and palindrome
    */
    public static void findPrimePalindrome(int nums){
        ArrayList <Integer> arr_prime = findPrime(nums);
        ArrayList <StringBuilder> arr_prime_str = new ArrayList<>();
        
        for (int i=0;i<arr_prime.size();i++){
            int prime_num = arr_prime.get(i);
            //Convert integers into stringbuilder
            StringBuilder sb1 = new StringBuilder();
            sb1.append(Integer.toString(prime_num));
            
            // compare two prime numbers
            for (int j=i+1;j<arr_prime.size();j++){
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Integer.toString(arr_prime.get(j)));
                
                // first compare the sizes
                if (sb1.length()==sb2.length()){
                    int cnt_matching_chars=0;
                    
                    // Secondly check if two strings are palindrome(reverse of each other)
                    for (int k=0;k<sb1.length();k++){
                        if (sb1.charAt(k)== sb2.charAt(sb2.length()-k-1)){
                            cnt_matching_chars++;
                        }
                    }
                    if (cnt_matching_chars == sb1.length()){
                        arr_prime_str.add(sb1);
                        arr_prime_str.add(sb2);
                    }                                       
                }
            }
        }
        System.out.println("Prime numbers between 1 and 1000 which are palindrome of each other are:");
        for (StringBuilder s:arr_prime_str){
            System.out.print(s+" ");
        }
    }
    // Find prime numbers which are anagrams of each other
    public static void findPrimeAnagram(int nums){
        ArrayList <Integer> arr_prime = findPrime(nums);
        Map<Integer, StringBuilder> map_prime_anag = new HashMap();
        
        for (int i=0;i<arr_prime.size();i++){
            int prime_num = arr_prime.get(i);
            //Convert integers into stringbuilder
            StringBuilder sb1 = new StringBuilder();
            sb1.append(Integer.toString(prime_num));

            // compare two prime numbers
            for (int j=i+1;j<arr_prime.size();j++){
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Integer.toString(arr_prime.get(j)));
                // first compare the sizes
                if (sb1.length()==sb2.length()){
                    StringBuilder sb_temp1 = new StringBuilder(sb1);
                    StringBuilder sb_temp2 = new StringBuilder(sb2);
                    
                    // Check if two strings are anagram(have characters of each other)
                    for (int k=0;k<sb1.length();k++){
                        int m = 0;                  
                        // Delete the digits if present in each number
                        while (sb_temp1.length()>0 && m<sb_temp1.length()){
                            if (sb_temp1.charAt(0)== sb_temp2.charAt(m)){
                                sb_temp2.deleteCharAt(m);   
                                sb_temp1.deleteCharAt(0);
                            }
                            m++;
                        }                
                    // when both numbers have no digits remaining    
                    if (sb_temp1.length()==0 && sb_temp2.length()==0){
                        // Add prime numbers to the hashmap if not already present 
                        map_prime_anag.putIfAbsent(i,sb1);
                        map_prime_anag.putIfAbsent(j,sb2);    
                    }
                    }
                }
            }
        }
        System.out.println("Between 1 and 1000 ");
        System.out.println("Prime Numbers which are anagarams of each other are:");
        System.out.print(map_prime_anag.values());
    }
    public static void main(String []args){
        findPrimeAnagram(1000);
    }
}

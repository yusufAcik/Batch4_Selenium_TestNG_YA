package com.krafttech.tests.day05_XPath_and_CSS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaSorusuAlternatif {
    public static void main(String[] args) {

        /**
         * Given a string s, return the longest palindromic substring in s.
         * Example 1:
         * Input: s = "babad"
         * Output: "bab"
         * Explanation: "aba" is also a valid answer.
         * Example 2:
         * Input: s = "cbbd"
         * Output: "bb"
         */

        String  s = "babad";
        System.out.println("longestPalindromic(s) = " + longestPalindromic(s));


    }

    public static String longestPalindromic(String str){
        List<String> allSubs = new ArrayList<>();
        int max=0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <=str.length() ; j++) {
                String newStr = str.substring(i,j);
                if(isPalindrome(newStr)&&newStr.length()>max){
                    allSubs.add(0,newStr);
                    max=newStr.length();
                }

            }
        }
        System.out.println("allSubs = " + allSubs);
           return allSubs.get(0);
    }

    public static boolean isPalindrome(String str){
        String reverse="";

        for (int i=str.length()-1;0<=i;i--){
            reverse+=str.charAt(i);
        }
        return str.equals(reverse) ? true : false;
    }


    public static boolean isPalindrome2(String str){
        return str.equals(new StringBuffer(str).reverse().toString());
    }





}

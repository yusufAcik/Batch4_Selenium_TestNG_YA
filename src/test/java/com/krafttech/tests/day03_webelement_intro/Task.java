package com.krafttech.tests.day03_webelement_intro;

import java.util.Arrays;

public class Task {
    public static void main(String[] args) {

        String str = "red2 blue5 black1 green3 gold4";
        // result = black red green gold blue

        System.out.println(orderColor(str));



    }
    public static String orderColor(String str){
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i]=words[i].substring(words[i].length()-1)+words[i];
        }
        System.out.println("Arrays.toString(words) = " + Arrays.toString(words));
        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replace(words[i].substring(0,1),"" );
        }

       /* String result = "";
        for (String word : words) {
            result+=word+" ";
        }*/
        String joined = String.join(" ",words);
        return joined;
    }
}

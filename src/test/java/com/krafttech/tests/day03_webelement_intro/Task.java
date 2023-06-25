package com.krafttech.tests.day03_webelement_intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    public static void main(String[] args) {

        String str = "red2 blue5 black1 green3 gold4";
        // result = black red green gold blue

       // System.out.println(orderColor(str));

        String str2="red24 blue54 black188 green33 gold33";
        System.out.println(orderColors_1(str2));


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

    //        String str2="red24 blue54 black188 green33 gold33";

    public static String orderColors_1(String str){
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if(Integer.parseInt(words[i].replaceAll("[^0-9]",""))>
                Integer.parseInt(words[j].replaceAll("[^0-9]","")))
                // ^ 0-9 --> 0-9 arası hariç herşeyi siler
                {
                    String temp=words[i];
                    words[i]=words[j];
                    words[j]=temp;
                }

            }
        }
        System.out.println(Arrays.toString(words));
        String joined = String.join(" ",words).replaceAll("[0-9]","");
        // 0-9 arası her şeyi siler
        return joined;
    }


}

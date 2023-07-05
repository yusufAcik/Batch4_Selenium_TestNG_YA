package com.krafttech.tests.day08_Alerts_MultipleWindows;

public class JavaQuestion {
    public static void main(String[] args) {

        /*
        Java sorumuz:
valid parantheses : verilen bir string'de parantezler uygun olarak açılıp kapandığını kontrol eden metod..
eğer uygun ise true, değilse false sonucunu vermeli..
valid nasıl kontrol edilecek:
1- eğer bir parantez açılmış ise kapanmalı
2- açık parantez kalmamalı
3-açılmamış parantez kapanmamalı
örnek: String s="((()))" valid

String s="((()))("  invalid
String s="()(()(()))" valid
String s="((())())" valid
String s="((())()()" invalid
String s="(()))()()(()" invalid
bu böyle uzar gider...
kolay gelsin..
         */


    }
    public static boolean isValidParantheses(String str){
        while (str.contains("()")){
            str=str.replace("()","");
        }
        return str.isEmpty();
    }

    public static boolean isValidParantheses_1(String str){
        char[] chars = str.toCharArray();
        int count=0;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='('){
                count++;
            }
            if(chars[i]==')'){
                count--;
            }
            if(count<0){
                return false;
            }
        }
        return count==0;
    }
}

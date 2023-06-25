package com.krafttech.tests.day03_webelement_intro;

import java.util.ArrayList;
import java.util.List;

public class JavaTricks {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(11);
        list.add(11);

        System.out.println(list);
        list.removeIf(e->e<6); // 6 dan küçük elementleri siler
        System.out.println(list);
        //*****************//
        System.out.println(list.stream().distinct().count()); // her bir farklı elementi sayar(birden fazla olanları tek sayar)
        System.out.println(list.stream().distinct().toList()); // birbirinden farklı elementleri liste yapar
    }
}

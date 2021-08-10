package com;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class CyclesTest {
    public static void main(String[] args) {

        /**
         * 1 итерация
         * НАЧАЛО
         * i = 0;
         * i < 3 <=> 0 < 3 -> true
         * если true тогда зайдем и распечатаем "Hello world"
         * КОНЕЦ
         * i++ -> i  = i + 1; i = 0 + 1 = 1;
         *
         * 2 итерация
         * НАЧАЛО
         * i=1
         * i<3 <=> 1 < 3 -> true
         * если true тогда зайдем и распечатаем "Hello world"
         * КОНЕЦ
         * i++ -> i  = i + 1; i = 1 + 1 = 2;
         *
         *
         * 3 итерация
         * НАЧАЛО
         * i=2
         * i<3 <=> 2 < 3 -> true
         * если true тогда зайдем и распечатаем "Hello world"
         * КОНЕЦ
         * i++ -> i  = i + 1; i = 2 + 1 = 3;
         *
         * 4 итерация
         * НАЧАЛО
         * i=3
         * i<3 <=> 3 < 3 -> false
         */
        /**
         * если у Вас четные числа то инкремент делать на +4 если нечентные числа то +7
         */
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
              continue;
            }
            System.out.println(i);

        }
        //System.out.println(i);
        // System.out.println("Bye - bye");

        Scanner scanner = new Scanner(System.in);

        int number = 0;
        while (true) {
            number = scanner.nextInt();
            System.out.println("юзер ввел число " + number);
            if (number < 0) {
                break;
            }
        }
        System.out.println("Bye - bye with number " + number);



    }
}

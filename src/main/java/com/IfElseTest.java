package com;

public class IfElseTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        /**
         *  если a > b или a = 0 тогда c = 7
         *
         *  если a == b тогда c = a+b;
         *
         *  если a < 0 и b > 0 тогда с = b - a
         *
         *  иначе c = 10
         */


        /**
         *  //int c = a > b ? 3 : 4;
         */
        int c = a > b || a == 0 ? (7) : (a == b ? (a + b) : (a < 0 && b > 0 ? (b - a) : (10)));


        if (a > b || a == 0) {
            c = 7;
        } else if (a == b) {
            c = a + b;
        } else if (a < 0 && b > 0) {
            c = b - a;
        } else {
            c = 10;
        }
        System.out.println("c =" + c);



    }
}

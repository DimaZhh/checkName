package com;

public class IncrementDecrementTest {
    public static void main(String[] args) {
        int a = 2;

        int b = ++a/**3**/ + ++a/**4**/ + a++/**4 (+1)**)**/ +/**(+1)**/ a++/**5**/;
        //1+a-> 3 +   1+a -> 1+3 -> 4
        System.out.println(b);//16
        System.out.println(a);//6

    }
}

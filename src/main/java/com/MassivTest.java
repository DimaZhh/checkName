package com;

import java.util.Arrays;
import java.util.Collections;

public class MassivTest {
    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 4, 5, -81, 56};//[[1][2][3]...[81][56]]
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] < min) {
                min = numbers[i];
            }

        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers);

        Integer mas[] = {1, 2, 3, 4};
        Arrays.sort(mas, Collections.reverseOrder());
        System.out.println(Arrays.toString(mas));
    }
}

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Earth {

    String location;

    public static void main(String[] args) {

        int countNumbers = 10;

        while (countNumbers >= 0) {
            //System.out.println("ddddd " + countNumbers);
            countNumbers--;
        }

        //====================================================================================

        int countNumbers2 = -11;

        do {
            //System.out.println("countNumber2 = " + countNumbers2);
            countNumbers2++;
        } while (countNumbers2 < 0);

        //====================================================================================

        for (int i = 0; i < 11; i++) {
            //System.out.println("Line #" + i);
        }

        //====================================================================================

        String[] arrayOfStrings = {"String1", "String2", "String3", "String4"};

        for (String vudymonoMnoy : arrayOfStrings) {
            if (!vudymonoMnoy.equals("String3")) {
                //System.out.println(vudymonoMnoy);
            }
        }

        int[] numbers = {111, 2, 3, 4, 11, 44, 1, 3, 1111};
        int min = numbers[0];
        for (int i=0; i < numbers.length; i++) {
            if (numbers[i] > min) {
                min = numbers[i];
            }
        }

        System.out.println(min);


        //====================================================================================

        if (1>5) {
            System.out.println("true OR not");
        } else if(1>3) {
            System.out.println("this is else22222333333");
        }

        int a = 11;
        int b = 16;
        int c = a<b ? 11 : 111;

        //System.out.println(c);
    }
}

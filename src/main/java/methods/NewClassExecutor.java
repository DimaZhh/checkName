package methods;

public class NewClassExecutor {


    public void plusSomething(int number) {
        number = number+100;
    }

    public void minusSomething(int number) {
        number = number-100;
        System.out.println("number inside method - " + number);
    }


    public static void main(String[] args) {
        NewClassExecutor newClassExecutor = new NewClassExecutor();
        int ourNumber = 1;

        System.out.println("what is number");
        System.out.println(ourNumber);

        newClassExecutor.minusSomething(ourNumber);
        System.out.println("what is number now");
        System.out.println(ourNumber);
    }
}

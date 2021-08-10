package objects;

public class ExecutorOverWindow {

    public static void main(String[] args) {
        OperationAroundWindow operationAroundWindow = new OperationAroundWindow();
        Window window = new Window(1);

        System.out.println("Window size #1");
        System.out.println(window.size);

        System.out.println("Window size #2 - when plus");
        operationAroundWindow.plusSize(window);
        System.out.println(window.size);

        System.out.println("Window size #3 - when minus");
        operationAroundWindow.minusSize(window);
        System.out.println(window.size);
    }
}

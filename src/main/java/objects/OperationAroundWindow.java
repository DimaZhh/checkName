package objects;

public class OperationAroundWindow {

    public void plusSize(Window window) {
        window = new Window(window.size);
        window.size = window.size + 100;
    }

    public void minusSize(Window window) {
        window = new Window(window.size);
        window.size = window.size -100;
    }

}

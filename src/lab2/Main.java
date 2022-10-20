package lab2;

public class Main {
    public static void main(String[] args) {
        InputDevice id = new InputDevice();
        OutputDevice od = new OutputDevice();
        Application app = new Application(id, od);
        app.run();
    }
}
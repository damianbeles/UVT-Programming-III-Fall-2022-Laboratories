package lab5;

public class Main {
    public static void main(String[] args) {
        InputDevice id = new InputDevice(System.in);
        OutputDevice od = new OutputDevice(System.out);
        Application app = new Application(id, od);
        app.run();
    }
}

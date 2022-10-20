package lab1;

import java.util.Arrays;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;

    Application(InputDevice id, OutputDevice od) {
        this.inputDevice = id;
        this.outputDevice = od;
    }

    void run() {
        this.outputDevice.writeMessage("Application started");
        this.outputDevice.writeMessage("Today’s  lucky  numbers  are: " + this.inputDevice.nextInt() + " " + this.inputDevice.nextInt());
    }
}

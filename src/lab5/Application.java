package lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;

    Application(InputDevice id, OutputDevice od) {
        this.inputDevice = id;
        this.outputDevice = od;
    }
    void askUserForFile() {
        InputDevice id1 = new InputDevice(System.in);
        boolean fileOpened = false;
        while (!fileOpened) {
            String fileName = id1.getLine();
            try {
                InputDevice id2 = new InputDevice(new FileInputStream(fileName)); // < exception here
                fileOpened = true;
                System.out.println("File content: " + id2.getLine());
            } catch (FileNotFoundException e) {
                System.out.println("There was an error trying to open " + fileName + ", please input other file:");
            }
        }
    }

    void run() {
//        this.outputDevice.writeMessage("Application started\n");
//        this.outputDevice.writeMessage("Today’s  lucky  numbers  are: " + this.inputDevice.nextInt() + " " + this.inputDevice.nextInt() + "\n");
//        this.outputDevice.writeMessage(this.inputDevice.getLine());
        askUserForFile();
    }
}

package lab5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class InputDevice {
    InputStream is;

    InputDevice(InputStream inputStream) {
        this.is = inputStream;
    }

    String getLine() {
        Scanner scanner = new Scanner(this.is);
        return scanner.nextLine();
    }

    int nextInt() {
        return (int) (Math.random() * 100);
    }
}

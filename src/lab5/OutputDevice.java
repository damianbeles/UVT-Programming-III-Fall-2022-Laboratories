package lab5;

import java.io.IOException;
import java.io.OutputStream;

public class OutputDevice {
    OutputStream os;

    OutputDevice(OutputStream outputStream) {
        this.os = outputStream;
    }

    void writeMessage(String mess) {
        try {
            this.os.write(mess.getBytes());
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}

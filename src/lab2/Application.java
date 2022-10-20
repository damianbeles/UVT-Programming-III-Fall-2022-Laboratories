package lab2;

import java.util.Arrays;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;

    Application(InputDevice id, OutputDevice od) {
        this.inputDevice = id;
        this.outputDevice = od;
    }

    int[] sortNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; ++i) {
            for (int j = i + 1; j < numbers.length - 1; ++j) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    int[] randomArraySort() {
        return this.sortNumbers(this.inputDevice.getNumbers(7));
    }

    int longestWordSize(String sentence) {
        String[] words = sentence.split(" ");
        int longestWord = words[0].length();
        for (String s : words) {
            if (s.length() > longestWord) {
                longestWord = s.length();
            }
        }
        return longestWord;
    }

    int[] wordSizeHistogram(String sentence) {
        String[] words = sentence.split(" ");
        int[] appearances = new int[this.longestWordSize(sentence) + 1];
        for (String word : words) {
            appearances[word.length()]++;
        }
        return appearances;
    }

    void run() {
//        this.outputDevice.writeMessage("Application started");
//        this.outputDevice.writeMessage("Today’s  lucky  numbers  are: " + this.inputDevice.nextInt() + " " + this.inputDevice.nextInt());
//        this.outputDevice.writeMessage(Arrays.toString(this.inputDevice.getNumbers(5)));
//        this.outputDevice.writeMessage(Arrays.toString(this.randomArraySort()));
        this.outputDevice.writeMessage(Arrays.toString(this.wordSizeHistogram(this.inputDevice.getLine())));
    }
}

package lab2;

public class InputDevice {
    String getLine() {
        return "The quick brown fox jumps over the lazy dog";
    }

    int nextInt() {
        return (int) (Math.random() * 100);
    }

    int[] getNumbers(int n) {
        int[] randomNumbers = new int[n];
        for (int i = 0; i < n; ++i) {
            randomNumbers[i] = this.nextInt();
        }
        return randomNumbers;
    }
}


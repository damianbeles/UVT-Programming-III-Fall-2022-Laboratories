package lab3;

public class InputDevice {
    String getLine() {
        return "The quick brown fox jumps over the lazy dog";
    }

    int nextInt() {
        return (int) (Math.random() * 100);
    }

    Fruit[] readFruit() {
        Fruit[] fruits = new Fruit[4];
        fruits[0] = new Banana(100, 4, 20);
        fruits[1] = new Apple(60, 2, 25, Color.GREEN);
        fruits[2] = new Apple(55, 2, 20.2f, Color.RED);
        fruits[3] = new Mango(60, 4, 15.5f, Color.RED);
        return fruits;
    }
}

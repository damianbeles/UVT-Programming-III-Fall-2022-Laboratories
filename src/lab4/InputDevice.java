package lab4;

import java.sql.Array;
import java.util.ArrayList;

public class InputDevice {
    String getLine() {
        return "The quick brown fox jumps over the lazy dog";
    }

    int nextInt() {
        return (int) (Math.random() * 100);
    }

    ArrayList<Fruit> readFruit() {
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Banana(100, 4, 20));
        fruits.add(new Apple(10, 2, 25, Color.GREEN));
        fruits.add(new Apple(55, 2, 20.2f, Color.RED));
        fruits.add(new Mango(60, 4, 15.5f, Color.RED));
        return fruits;
    }
}

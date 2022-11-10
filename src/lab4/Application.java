package lab4;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;

    Application(InputDevice id, OutputDevice od) {
        this.inputDevice = id;
        this.outputDevice = od;
    }

    float computeWeights(Fruit[] fruits) {
        float sum = 0;
        for (Fruit f : fruits) {
            sum += f.weight;
        }
        return sum;
    }

    int computeSugarContent(Fruit[] fruits) {
        int sum = 0;
        for (Fruit f : fruits) {
            sum += f.sugarContent;
        }
        return sum;
    }

    void prepareFruits(Fruit[] fruits) {
        for (Fruit fruit : fruits) {
            if (fruit instanceof Apple) {
                this.outputDevice.writeMessage("Removing seeds from apple ...");
                ((Apple) fruit).removeSeeds();
            } else if (fruit instanceof Banana) {
                this.outputDevice.writeMessage("Peeling off the banana ...");
                ((Banana) fruit).peelOff();
            } else if (fruit instanceof Mango) {
                this.outputDevice.writeMessage("Peeling off the mango and remove the seeds ...");
                ((Mango) fruit).peelOff();
                ((Mango) fruit).removeSeeds();
            }
        }
    }

    HashMap<String, Integer> countFruits(ArrayList<Fruit> fruits) {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (Fruit fruit : fruits) {
            if (fruit instanceof Apple) {
                if (counts.containsKey("apple")) {
                    counts.put("apple", counts.get("apple") + 1);
                } else {
                    counts.put("apple", 1);
                }
            } else if (fruit instanceof Banana) {
                if (counts.containsKey("banana")) {
                    counts.put("banana", counts.get("banana") + 1);
                } else {
                    counts.put("banana", 1);
                }
            } else if (fruit instanceof Mango) {
                if (counts.containsKey("mango")) {
                    counts.put("mango", counts.get("mango") + 1);
                } else {
                    counts.put("mango", 1);
                }
            }
        }
        return counts;
    }

    void fruitComparison(ArrayList<Fruit> fruits) {
        this.outputDevice.writeMessage("Initial array: " + Arrays.toString(fruits.toArray()));
        Collections.sort(fruits);
        this.outputDevice.writeMessage("Sorted array: " + Arrays.toString(fruits.toArray()));
        this.outputDevice.writeMessage("Min: " + Collections.min(fruits));
        this.outputDevice.writeMessage("Max: " + Collections.max(fruits));
    }

    String appearsMost(ArrayList<Fruit> fruits) {
        HashMap<String, Integer> counts = countFruits(fruits);
        int maxCount = 0;
        String maxAppearances = "";
        for (String key : counts.keySet()) {
            if (counts.get(key) > maxCount) {
                maxCount = counts.get(key);
                maxAppearances = key;
            }
        }
        return maxAppearances;
    }

    void run() {
//        this.outputDevice.writeMessage("Total weight: " + computeWeights(this.inputDevice.readFruit()));
//        this.outputDevice.writeMessage("Total sugar content: " + computeSugarContent(this.inputDevice.readFruit()));
//        Banana b = new Banana(100, 4, 20);
//        this.outputDevice.writeMessage("Banana has peel: " + b.hasPeel());
//        b.peelOff();
//        this.outputDevice.writeMessage("Banana has peel: " + b.hasPeel());
//
//        Apple a = new Apple(100, 4, 20, Color.GREEN);
//        this.outputDevice.writeMessage("Apple has seeds: " + a.hasSeeds());
//        a.removeSeeds();
//        this.outputDevice.writeMessage("Apple has seeds: " + a.hasSeeds());
//
        ArrayList<Fruit> fruits = this.inputDevice.readFruit();
//        HashMap<String, Integer> counts = countFruits(fruits);
//
//        for (String key : counts.keySet()) {
//            System.out.println(key + ": " + counts.get(key));
//        }

        fruitComparison(fruits);
        this.outputDevice.writeMessage("Most appearances: " + appearsMost(fruits));


        /* STREAMS */
        ArrayList<Fruit> fruitsWithSugarContentHigherThan20 = fruits
                .stream()
                .filter((fruit) -> fruit.sugarContent > 20)
                .collect(Collectors.toCollection(ArrayList<Fruit>::new));
        this.outputDevice.writeMessage(Arrays.toString(fruitsWithSugarContentHigherThan20.toArray()));

        int sugarCountSum = fruits
                .stream()
                .mapToInt(fruit -> fruit.sugarContent)
                .sum();
        this.outputDevice.writeMessage("Total sugar content: " + sugarCountSum);

        List sugarToWaterRatios = fruits
                .stream()
                .map(fruit -> 1.0 * fruit.sugarContent / fruit.waterContent)
                .toList();
        this.outputDevice.writeMessage("Sugar to water ratios: " + sugarToWaterRatios);
        /* END STREAMS */
    }
}

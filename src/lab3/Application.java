package lab3;

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

        this.prepareFruits(this.inputDevice.readFruit());
    }
}

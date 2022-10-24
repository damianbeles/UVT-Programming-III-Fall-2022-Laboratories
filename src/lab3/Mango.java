package lab3;

public class Mango extends Fruit implements Peelable, SeedRemovable {
    private boolean seedsRemoved;
    private boolean peeledOff;

    Mango(int sc, int wc, float w, Color c) {
        super(sc, wc, w, c);
        this.peeledOff = false;
        this.seedsRemoved = false;
    }

    @Override
    public void peelOff() {
        this.peeledOff = true;
    }

    @Override
    public boolean hasPeel() {
        return !this.peeledOff;
    }

    @Override
    public boolean hasSeeds() {
        return !this.seedsRemoved;
    }

    @Override
    public void removeSeeds() {
        this.seedsRemoved = true;
    }
}

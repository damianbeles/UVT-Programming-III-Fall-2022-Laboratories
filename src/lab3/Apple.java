package lab3;

public class Apple extends Fruit implements SeedRemovable {
    private boolean seedsRemoved;

    Apple(int sc, int wc, float w, Color c) {
        super(sc, wc, w, c);
        this.seedsRemoved = false;
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
